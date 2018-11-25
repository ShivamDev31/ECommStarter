package io.kotlin.ecommstarter.home.viewstate

import io.kotlin.ecommstarter.home.viewstate.HomeViewStateConverter.*

abstract class EcommerceHomeViewState {

    abstract fun homeViewStates(): List<HomeViewState>

    abstract fun accept(visitor: Visitor)

    interface Visitor {

        fun visit(idleViewState: HomeIdleViewState)

        fun visit(errorViewState: HomeErrorViewState)

        fun visit(loadingViewState: HomeLoadingViewState)
    }

}
