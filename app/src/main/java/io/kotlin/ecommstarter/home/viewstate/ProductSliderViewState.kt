package io.kotlin.ecommstarter.home.viewstate

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ProductSliderViewState(var sliderProducts: List<SliderProduct>) : HomeViewState {
    override fun type() = HomeViewState.Type.SLIDER_PRODUCT
}

@Parcelize
data class SliderProduct(val id: String,
                         val name: String,
                         val price: Double,
                         val imageUrl: String) : Parcelable
