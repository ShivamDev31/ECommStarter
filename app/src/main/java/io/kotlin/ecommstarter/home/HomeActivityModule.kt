package io.kotlin.ecommstarter.home

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.kotlin.ecommstarter.home.api.HomeApiFetcher
import io.kotlin.ecommstarter.home.api.HomeFetcher
import io.kotlin.ecommstarter.rx.AndroidSchedulingStrategyFactory
import retrofit2.Retrofit

@Module
class HomeActivityModule {

    @Provides
    fun ecommerceFetcher(retrofit: Retrofit, moshi: Moshi): HomeFetcher {
        return HomeApiFetcher.from(retrofit, moshi)
    }

    @Provides
    fun homeUseCase(homeFetcher: HomeFetcher): HomeUseCase {
        return HomeUseCase(homeFetcher, AndroidSchedulingStrategyFactory.io())
    }

    @Provides
    fun homePresenter(homeUseCase: HomeUseCase): HomePresenter {
        return HomePresenter(homeUseCase)
    }

}
