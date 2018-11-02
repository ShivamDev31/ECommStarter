package io.kotlin.ecommstarter.rx

import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.CompletableTransformer
import io.reactivex.Maybe
import io.reactivex.MaybeSource
import io.reactivex.MaybeTransformer
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer

class SchedulingStrategy<T>(private val subscribingScheduler: Scheduler, private val observingScheduler: Scheduler) :
        ObservableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }

    override fun apply(upstream: Maybe<T>): MaybeSource<T> {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }

    override fun apply(upstream: Completable): CompletableSource {
        return upstream
                .subscribeOn(subscribingScheduler)
                .observeOn(observingScheduler)
    }

    open class Factory(private val subscribingScheduler: Scheduler, private val observingScheduler: Scheduler) {
        fun <T> create(): SchedulingStrategy<T> {
            return SchedulingStrategy(subscribingScheduler, observingScheduler)
        }

        fun getSubscribingScheduler(): Scheduler {
            return subscribingScheduler
        }
    }

}
