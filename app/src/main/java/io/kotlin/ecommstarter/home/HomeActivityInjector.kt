package io.kotlin.ecommstarter.home

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [HomeActivityModule::class])
interface HomeActivityInjector : AndroidInjector<HomeActivity> {

    override fun inject(instance: HomeActivity)

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<HomeActivity>() {

        abstract override fun build(): HomeActivityInjector
    }

}
