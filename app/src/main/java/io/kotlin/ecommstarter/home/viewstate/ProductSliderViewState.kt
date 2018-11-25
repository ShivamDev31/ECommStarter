package io.kotlin.ecommstarter.home.viewstate

class ProductSliderViewState(val id: String,
                             val name: String,
                             val price: Double,
                             val imageUrl: String): HomeViewState {


    override fun type() = HomeViewState.Type.SLIDER_PRODUCT
}
