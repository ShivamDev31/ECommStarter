package io.kotlin.ecommstarter.home

import io.kotlin.ecommstarter.navigator.Navigator
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import timber.log.Timber

class HomePresenter(private val homeUseCase: HomeUseCase, private val displayer: HomeDisplayer, navigator: Navigator) {

    private var disposable: Disposable = Disposables.empty()

    companion object {
        fun create(homeUseCase: HomeUseCase, homeDisplayer: HomeDisplayer, navigator: Navigator): HomePresenter {
            return HomePresenter(homeUseCase, homeDisplayer, navigator)
        }
    }

    fun startPresenting() {
        disposable = homeUseCase.homeFeed()
                .subscribe({
                    displayer.show(it)
                    Timber.d("XXXX : $it")
                }, Timber::e)
    }

    fun stopPresenting() {
        disposable.dispose()
    }
}
