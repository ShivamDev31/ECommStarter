package io.kotlin.ecommstarter.app

import android.app.Application
import io.kotlin.ecommstarter.di.ApplicationInjector
import io.kotlin.ecommstarter.di.DaggerApplicationInjector

class EcommApp : InjectableApp(ApplicationAndroidFactory()) {

    class ApplicationAndroidFactory : ApplicationInjector.Factory {
        override fun create(application: Application): ApplicationInjector {
            return DaggerApplicationInjector.builder()
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
