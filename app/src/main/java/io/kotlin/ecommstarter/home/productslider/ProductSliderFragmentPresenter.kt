package io.kotlin.ecommstarter.home.productslider

import io.kotlin.ecommstarter.home.viewstate.SliderProduct
import timber.log.Timber

class ProductSliderFragmentPresenter(private val productSliderView: ProductSliderView) : ProductSliderView.Listener {

    override fun onSliderClicked(product: SliderProduct) {
        Timber.d("XXXX : Product clicked : $product")
    }

    companion object {
        fun from(productSliderView: ProductSliderView): ProductSliderFragmentPresenter {
            return ProductSliderFragmentPresenter(productSliderView)
        }
    }

    fun startPresenting() {
        productSliderView.show()
        productSliderView.setListener(this)
    }

    fun stopPresenting() {
        // no op
    }

}
