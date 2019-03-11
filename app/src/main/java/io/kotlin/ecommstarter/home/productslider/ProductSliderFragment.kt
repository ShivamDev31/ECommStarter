package io.kotlin.ecommstarter.home.productslider

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import io.kotlin.ecommstarter.R
import io.kotlin.ecommstarter.home.viewstate.SliderProduct
import javax.inject.Inject

private const val KEY_ITEMS = "key_product_items"

class ProductSliderFragment : Fragment() {

    @Inject lateinit var presenter: ProductSliderFragmentPresenter

    companion object {
        fun create(item: SliderProduct): ProductSliderFragment {
            val fragment = ProductSliderFragment()
            val bundle = Bundle()
            bundle.putParcelable(KEY_ITEMS, item)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_product_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
        presenter.startPresenting()
    }

    override fun onDestroyView() {
        presenter.stopPresenting()
        super.onDestroyView()
    }

    fun getSliderProduct(): SliderProduct? {
        return arguments?.getParcelable(KEY_ITEMS)
    }

}
