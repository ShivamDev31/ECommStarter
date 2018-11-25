package io.kotlin.ecommstarter.home.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import io.kotlin.ecommstarter.home.viewstate.HomeViewState
import io.kotlin.ecommstarter.home.viewstate.ProductListViewState
import io.kotlin.ecommstarter.imageloader.ImageLoader
import kotlinx.android.synthetic.main.item_product_list.view.*

class ProductListViewHolder(inflater: LayoutInflater, parent: ViewGroup, private val imageLoader: ImageLoader)
    : HomeViewHolder(inflater, parent, HomeViewState.Type.LIST_PRODUCT) {

    override fun bind(viewState: HomeViewState) {
        val product = viewState as ProductListViewState
        imageLoader.load(product.imageUrl).into(itemView.ivProductImage)
        itemView.tvProductName.text = product.name
        itemView.tvProductPrice.text = "${product.price}"
    }
}
