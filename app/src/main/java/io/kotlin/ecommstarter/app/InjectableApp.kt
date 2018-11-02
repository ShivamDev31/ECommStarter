package io.kotlin.ecommstarter.app

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.kotlin.ecommstarter.di.ApplicationInjector
import javax.inject.Inject

abstract class InjectableApp(private val applicationInjectorFactory: ApplicationInjector.Factory) : Application(), HasActivityInjector {

    @Inject
    internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        val applicationInjector = applicationInjectorFactory.create(this)
        applicationInjector.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}
