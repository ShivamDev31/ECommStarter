package io.kotlin.ecommstarter.home.viewstate

import androidx.annotation.LayoutRes
import io.kotlin.ecommstarter.R

interface HomeViewState {

    enum class Type constructor(@LayoutRes val layoutId: Int) {
        SLIDER_PRODUCT(R.layout.item_product_slider),
        PRODUCTS_LIST(R.layout.item_product_list);

        companion object {
            fun from(value: Int): Type = Type.values()[value]
        }

        fun layoutId(): Int {
            return layoutId
        }

        fun value(): Int = ordinal
    }

    fun type(): Type
}
