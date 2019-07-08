package io.kotlin.ecommstarter.home.viewstate

data class ProductListViewState(val id: String,
                                val name: String,
                                val price: Double,
                                val imageUrl: String) : HomeViewState {
    override fun type() = HomeViewState.Type.LIST_PRODUCT
}
