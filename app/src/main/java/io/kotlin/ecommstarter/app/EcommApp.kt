package io.kotlin.ecommstarter.app

import android.app.Application
import android.util.Log
import io.kotlin.ecommstarter.BuildConfig
import io.kotlin.ecommstarter.di.ApplicationInjector
import io.kotlin.ecommstarter.di.DaggerApplicationInjector
import io.kotlin.ecommstarter.network.JsonModule
import io.kotlin.ecommstarter.network.NetworkModule
import timber.log.Timber
import timber.log.Timber.DebugTree


class EcommApp : InjectableApp(ApplicationAndroidFactory()) {

    class ApplicationAndroidFactory : ApplicationInjector.Factory {
        override fun create(application: Application): ApplicationInjector {
            return DaggerApplicationInjector.builder()
                    .networkModule(NetworkModule(application))
                    .jsonModule(JsonModule())
                    .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            // We can handle crashlytics tree here which will be used for production
            //Timber.plant(CrashReportingTree())
        }
    }
}
