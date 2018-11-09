package io.kotlin.ecommstarter.home

import io.kotlin.ecommstarter.home.api.EcommerceFetcher
import io.kotlin.ecommstarter.rx.AndroidSchedulingStrategyFactory
import io.reactivex.Observable

class HomeUseCase(private val ecommerceFetcher: EcommerceFetcher,
                  private val schedulingStrategyFactory: AndroidSchedulingStrategyFactory) {

    fun homeFeed(): Observable<EcommerceBlock> {
        return ecommerceFetcher.load()
                .compose(schedulingStrategyFactory.create())
                .toObservable()

    }

}
