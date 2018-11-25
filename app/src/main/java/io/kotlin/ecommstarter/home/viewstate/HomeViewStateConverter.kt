package io.kotlin.ecommstarter.home.viewstate

import io.kotlin.ecommstarter.home.AdBlock
import io.kotlin.ecommstarter.home.Block
import io.kotlin.ecommstarter.home.GridProductBlock
import io.kotlin.ecommstarter.home.HomeBlock
import io.kotlin.ecommstarter.home.ListProductBlock
import io.kotlin.ecommstarter.home.SliderProductBlock
import io.kotlin.ecommstarter.rx.Converter
import java.util.*

class HomeViewStateConverter : Converter<HomeBlock, EcommerceHomeViewState>, Block.Visitor {

    private val viewStates = mutableListOf<HomeViewState>()

    override fun apply(homeBlock: HomeBlock): EcommerceHomeViewState {
        homeBlock.blocks.forEach {
            it.accept(this)
        }
        return HomeIdleViewState(viewStates)
    }

    override fun visit(sliderProduct: SliderProductBlock) {
        val product = sliderProduct.product
        val viewState = ProductSliderViewState(product.id, product.name, product.price, product.imageUrl)
        viewStates.add(viewState)
    }

    override fun visit(listProduct: ListProductBlock) {
        val product = listProduct.product
        val viewState = ProductListViewState(product.id, product.name, product.price, product.imageUrl)
        viewStates.add(viewState)
    }

    override fun visit(gridProduct: GridProductBlock) {
        val product = gridProduct.product
        val viewState = GridProductViewState(product.id, product.name, product.price, product.imageUrl)
        viewStates.add(viewState)
    }

    override fun visit(adBlock: AdBlock) {
        val viewState = AdBlockViewState(adBlock.id, adBlock.adImageUrl, adBlock.adUrl, adBlock.shouldShow, adBlock.type)
        viewStates.add(viewState)
    }


    class HomeIdleViewState(private val viewStates: List<HomeViewState>) : EcommerceHomeViewState() {

        override fun homeViewStates(): List<HomeViewState> {
            return viewStates
        }

        override fun accept(visitor: Visitor) {
            visitor.visit(this)
        }
    }

    class HomeLoadingViewState : EcommerceHomeViewState() {
        override fun homeViewStates(): List<HomeViewState> {
            return Collections.emptyList()
        }

        override fun accept(visitor: Visitor) {
            visitor.visit(this)
        }

    }

    class HomeErrorViewState(cause: Throwable, errorType: Type) : EcommerceHomeViewState() {
        override fun homeViewStates(): List<HomeViewState> {
            return Collections.emptyList()
        }

        override fun accept(visitor: Visitor) {
            return visitor.visit(this)
        }

        enum class Type {
            SERVER,
            NOT_FOUND,
            CONNECTION,
            UNKNOWN;
        }
    }
}
