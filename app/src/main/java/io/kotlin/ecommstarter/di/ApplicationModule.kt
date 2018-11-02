package io.kotlin.ecommstarter.di

import android.app.Application
import dagger.Module
import dagger.Provides
import io.kotlin.ecommstarter.common.AndroidAssetLoader
import io.kotlin.ecommstarter.network.JsonModule
import io.kotlin.ecommstarter.network.NetworkModule
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, JsonModule::class])
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun application(): Application {
        return application
    }

    @Provides
    fun assetLoader(): AndroidAssetLoader {
        return AndroidAssetLoader(application)
    }

}
