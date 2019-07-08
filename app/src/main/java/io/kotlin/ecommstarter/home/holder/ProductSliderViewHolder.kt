package io.kotlin.ecommstarter.home.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import io.kotlin.ecommstarter.R
import io.kotlin.ecommstarter.home.adapter.ProductsSliderAdapter
import io.kotlin.ecommstarter.home.viewstate.HomeViewState
import io.kotlin.ecommstarter.home.viewstate.ProductSliderViewState
import io.kotlin.ecommstarter.imageloader.ImageLoader

class ProductSliderViewHolder(inflater: LayoutInflater, parent: ViewGroup, imageLoader: ImageLoader, private val sliderAdapter: ProductsSliderAdapter)
    : HomeViewHolder(inflater, parent, HomeViewState.Type.SLIDER_PRODUCT) {

    override fun bind(viewState: HomeViewState) {
        val product = viewState as ProductSliderViewState
        val productsPager = itemView.findViewById<ViewPager>(R.id.vpProducts)
        productsPager.adapter = sliderAdapter
        sliderAdapter.setItems(product)
    }
}
