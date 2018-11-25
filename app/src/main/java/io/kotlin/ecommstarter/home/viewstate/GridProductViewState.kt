package io.kotlin.ecommstarter.home.viewstate

class GridProductViewState(val id: String,
                           val name: String,
                           val price: Double,
                           val imageUrl: String) : HomeViewState {

    override fun type() = HomeViewState.Type.GRID_PRODUCT
}
