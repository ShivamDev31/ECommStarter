package io.kotlin.ecommstarter.home

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.kotlin.ecommstarter.home.api.EcommerceApiFetcher
import io.kotlin.ecommstarter.home.api.EcommerceFetcher
import io.kotlin.ecommstarter.rx.AndroidSchedulingStrategyFactory
import retrofit2.Retrofit

@Module
class HomeActivityModule {

    @Provides
    fun ecommerceFetcher(retrofit: Retrofit, moshi: Moshi): EcommerceFetcher {
        return EcommerceApiFetcher.from(retrofit, moshi)
    }

    @Provides
    fun homeUseCase(ecommerceFetcher: EcommerceFetcher): HomeUseCase {
        return HomeUseCase(ecommerceFetcher, AndroidSchedulingStrategyFactory.io())
    }

    @Provides
    fun homePresenter(homeUseCase: HomeUseCase): HomePresenter {
        return HomePresenter(homeUseCase)
    }

}
