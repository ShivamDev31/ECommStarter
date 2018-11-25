package io.kotlin.ecommstarter.home

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.kotlin.ecommstarter.common.AssetLoader
import io.kotlin.ecommstarter.home.api.HomeApiFetcher
import io.kotlin.ecommstarter.home.api.HomeFetcher
import io.kotlin.ecommstarter.home.api.HomeLocalFetcher
import io.kotlin.ecommstarter.home.viewstate.HomeViewStateConverter
import io.kotlin.ecommstarter.imageloader.ImageLoader
import io.kotlin.ecommstarter.navigator.AndroidNavigator
import io.kotlin.ecommstarter.navigator.Navigator
import io.kotlin.ecommstarter.rx.AndroidSchedulingStrategyFactory
import retrofit2.Retrofit
import javax.inject.Named

@Module
class HomeActivityModule {

    @Provides
    fun navigator(activity: HomeActivity): Navigator {
        return AndroidNavigator(activity)
    }

    @Provides
    @Named("remote")
    fun ecommerceApiFetcher(retrofit: Retrofit, moshi: Moshi): HomeFetcher {
        return HomeApiFetcher.from(retrofit, moshi)
    }

    @Provides
    @Named("local")
    fun ecommerceLocalFetcher(moshi: Moshi, assetLoader: AssetLoader): HomeFetcher {
        return HomeLocalFetcher.from(moshi, assetLoader)
    }

    @Provides
    fun homeUseCase(@Named("remote") homeFetcher: HomeFetcher): HomeUseCase {
        val converter = HomeViewStateConverter()
        return HomeUseCase(homeFetcher, converter, AndroidSchedulingStrategyFactory.io())
    }

    @Provides
    fun homePresenter(homeUseCase: HomeUseCase, activity: HomeActivity, imageLoader: ImageLoader, navigator: Navigator): HomePresenter {
        val homeView = HomeView.from(activity, imageLoader)
        val homeDisplayer = HomeDisplayer(homeView)
        return HomePresenter.create(homeUseCase, homeDisplayer, navigator)
    }

}
