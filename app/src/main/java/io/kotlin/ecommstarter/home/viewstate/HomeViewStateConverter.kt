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
        val sliderProducts = ArrayList<SliderProduct>()
        sliderProduct.products.forEach {
            val product = SliderProduct(it.id, it.name, it.price, it.imageUrl)
            sliderProducts.add(product)
        }
        viewStates.add(ProductSliderViewState(sliderProducts))
    }

    override fun visit(listProduct: ListProductBlock) {
        val products = listProduct.products
        products.forEach {
            val viewState = ProductListViewState(it.id, it.name, it.price, it.imageUrl)
            viewStates.add(viewState)
        }
    }

    override fun visit(gridProduct: GridProductBlock) {
        val products = gridProduct.products
        products.forEach {
            val viewState = GridProductViewState(it.id, it.name, it.price, it.imageUrl)
            viewStates.add(viewState)
        }
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
