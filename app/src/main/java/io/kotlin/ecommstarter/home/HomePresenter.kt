package io.kotlin.ecommstarter.home

import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import timber.log.Timber

class HomePresenter(private val homeUseCase: HomeUseCase) {

    private var disposable: Disposable = Disposables.empty()

    fun startPresenting() {
        disposable = homeUseCase.homeFeed()
                .subscribe({
                    Timber.d("XXXX : $it")
                }, Timber::e)
    }

    fun stopPresenting() {
        disposable.dispose()
    }

}
