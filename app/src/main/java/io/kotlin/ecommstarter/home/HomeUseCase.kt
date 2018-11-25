package io.kotlin.ecommstarter.home

import io.kotlin.ecommstarter.home.api.HomeFetcher
import io.kotlin.ecommstarter.home.viewstate.EcommerceHomeViewState
import io.kotlin.ecommstarter.home.viewstate.HomeErrorViewStateConverter
import io.kotlin.ecommstarter.home.viewstate.HomeViewStateConverter
import io.kotlin.ecommstarter.home.viewstate.HomeViewStateConverter.HomeLoadingViewState
import io.kotlin.ecommstarter.rx.AndroidSchedulingStrategyFactory
import io.reactivex.Observable

class HomeUseCase(private val homeFetcher: HomeFetcher,
                  private val converter: HomeViewStateConverter,
                  private val schedulingStrategyFactory: AndroidSchedulingStrategyFactory) {

    fun homeFeed(): Observable<EcommerceHomeViewState> {
        val loadingViewState = HomeLoadingViewState()
        return homeFetcher
                .load()
                .toObservable()
                .map(converter)
                .startWith(loadingViewState)
                .compose(HomeErrorViewStateConverter())
                .compose(schedulingStrategyFactory.create())
    }
}
