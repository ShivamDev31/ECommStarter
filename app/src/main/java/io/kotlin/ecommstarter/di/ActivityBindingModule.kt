package io.kotlin.ecommstarter.di

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import io.kotlin.ecommstarter.home.HomeActivity
import io.kotlin.ecommstarter.home.HomeActivityInjector

@Module(subcomponents = [HomeActivityInjector::class])
interface ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    fun bindFeedActivity(builder: HomeActivityInjector.Builder): AndroidInjector.Factory<out Activity>

}
