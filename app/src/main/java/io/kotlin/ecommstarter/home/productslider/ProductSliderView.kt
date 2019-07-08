package io.kotlin.ecommstarter.home.productslider

import android.widget.ImageView
import android.widget.TextView
import io.kotlin.ecommstarter.R
import io.kotlin.ecommstarter.home.productslider.ProductSliderView.Listener.Companion.NO_OP
import io.kotlin.ecommstarter.home.viewstate.SliderProduct
import io.kotlin.ecommstarter.imageloader.ImageLoader

class ProductSliderView(private val ivProductImage: ImageView?,
                        private val tvProductName: TextView?,
                        private val tvProductPrice: TextView?,
                        private val product: SliderProduct?,
                        private val imageLoader: ImageLoader) {

    private var listener = NO_OP

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun show() {
        product?.let {
            ivProductImage?.let { ivProductImage -> imageLoader.load(product.imageUrl).into(ivProductImage) }
            tvProductName?.text = product.name
            tvProductPrice?.text = "${tvProductPrice?.context?.getString(R.string.rupee_symbol, "product.price")}"
        }
    }

    companion object {
        fun init(ivProductImage: ImageView?, tvProductName: TextView?, tvProductPrice: TextView?, product: SliderProduct?, imageLoader: ImageLoader)
                : ProductSliderView {
            return ProductSliderView(ivProductImage, tvProductName, tvProductPrice, product, imageLoader)
        }
    }

    interface Listener {

        companion object {
            val NO_OP = object : Listener {
                override fun onSliderClicked(product: SliderProduct) {
                    // no op
                }
            }
        }

        fun onSliderClicked(product: SliderProduct)
    }


}
