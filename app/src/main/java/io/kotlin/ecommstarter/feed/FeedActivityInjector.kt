package io.kotlin.ecommstarter.feed

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [FeedActivityModule::class])
interface FeedActivityInjector : AndroidInjector<FeedActivity> {

    override fun inject(instance: FeedActivity)

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<FeedActivity>() {

        abstract override fun build(): FeedActivityInjector
    }

}
