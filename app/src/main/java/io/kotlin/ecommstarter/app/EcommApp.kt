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
}
