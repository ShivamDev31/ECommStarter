package io.kotlin.ecommstarter.home.viewstate

import com.squareup.moshi.JsonEncodingException
import io.kotlin.ecommstarter.home.viewstate.HomeViewStateConverter.HomeErrorViewState
import io.kotlin.ecommstarter.home.viewstate.HomeViewStateConverter.HomeErrorViewState.Type.*
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function
import retrofit2.HttpException
import java.io.IOException

private const val HTTP_SERVER_ERROR_CODE = 500

class HomeErrorViewStateConverter : ObservableTransformer<EcommerceHomeViewState, EcommerceHomeViewState> {

    override fun apply(upstream: Observable<EcommerceHomeViewState>): ObservableSource<EcommerceHomeViewState> {
        return upstream
                .onErrorResumeNext(Function {
                    Observable.just(convertToCause(it))
                })
    }

    private fun convertToCause(cause: Throwable): EcommerceHomeViewState {
        return when (cause) {
            is HttpException -> {
                when (HTTP_SERVER_ERROR_CODE) {
                    cause.code() -> HomeErrorViewState(cause, SERVER)
                    else -> {
                        HomeErrorViewState(cause, NOT_FOUND)
                    }
                }
            }
            is JsonEncodingException -> {
                return HomeErrorViewState(cause, UNKNOWN)
            }
            is IOException -> {
                HomeErrorViewState(cause, CONNECTION)
            }
            else -> {
                HomeErrorViewState(cause, NOT_FOUND)
            }
        }
    }
}
