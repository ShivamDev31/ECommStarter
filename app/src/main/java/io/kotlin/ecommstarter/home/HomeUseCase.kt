package io.kotlin.ecommstarter.home

import io.kotlin.ecommstarter.home.api.HomeFetcher
import io.kotlin.ecommstarter.rx.AndroidSchedulingStrategyFactory
import io.reactivex.Observable

class HomeUseCase(private val homeFetcher: HomeFetcher,
                  private val schedulingStrategyFactory: AndroidSchedulingStrategyFactory) {

    fun homeFeed(): Observable<HomeBlock> {
        return homeFetcher.load()
                .compose(schedulingStrategyFactory.create())
                .toObservable()

    }

}
