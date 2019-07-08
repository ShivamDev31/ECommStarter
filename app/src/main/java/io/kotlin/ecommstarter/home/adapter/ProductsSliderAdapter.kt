package io.kotlin.ecommstarter.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.kotlin.ecommstarter.home.productslider.ProductSliderFragment
import io.kotlin.ecommstarter.home.viewstate.ProductSliderViewState
import io.kotlin.ecommstarter.home.viewstate.SliderProduct

class ProductsSliderAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val items = ArrayList<SliderProduct>()

    fun setItems(items: ProductSliderViewState) {
        this.items.clear()
        this.items.addAll(items.sliderProducts)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return ProductSliderFragment.create(items[position])
    }

    override fun getCount() = items.size

}
