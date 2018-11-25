package io.kotlin.ecommstarter.home

import io.kotlin.ecommstarter.home.viewstate.EcommerceHomeViewState
import io.kotlin.ecommstarter.home.viewstate.HomeViewStateConverter

class HomeDisplayer(private val homeView: HomeView) : EcommerceHomeViewState.Visitor {

    fun show(viewState: EcommerceHomeViewState) {
        viewState.accept(this)
    }

    override fun visit(idleViewState: HomeViewStateConverter.HomeIdleViewState) {
        homeView.show(idleViewState.homeViewStates())
    }

    override fun visit(errorViewState: HomeViewStateConverter.HomeErrorViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun visit(loadingViewState: HomeViewStateConverter.HomeLoadingViewState) {
        homeView.showLoading()
    }
}
