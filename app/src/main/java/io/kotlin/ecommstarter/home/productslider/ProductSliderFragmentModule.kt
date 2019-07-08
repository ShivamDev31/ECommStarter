package io.kotlin.ecommstarter.home.productslider

import android.widget.ImageView
import android.widget.TextView
import dagger.Module
import dagger.Provides
import io.kotlin.ecommstarter.imageloader.ImageLoader

@Module
class ProductSliderFragmentModule {

    @Provides
    fun productSliderView(fragment: ProductSliderFragment, imageLoader: ImageLoader): ProductSliderView {
        val view = fragment.view
        val ivProductImage = view?.findViewById<ImageView>(io.kotlin.ecommstarter.R.id.ivProductSliderImage)
        val tvProductName = view?.findViewById<TextView>(io.kotlin.ecommstarter.R.id.tvProductSliderName)
        val tvProductPrice = view?.findViewById<TextView>(io.kotlin.ecommstarter.R.id.tvProductSliderPrice)
        val sliderProduct = fragment.getSliderProduct()
        return ProductSliderView.init(ivProductImage, tvProductName, tvProductPrice, sliderProduct, imageLoader)
    }

    @Provides
    fun productSliderFragmentPresenter(productSliderView: ProductSliderView): ProductSliderFragmentPresenter {
        return ProductSliderFragmentPresenter.from(productSliderView)
    }

}
