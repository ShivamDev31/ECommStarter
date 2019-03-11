package io.kotlin.ecommstarter.home.productslider

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [ProductSliderFragmentModule::class])
interface ProductSliderFragmentInjector : AndroidInjector<ProductSliderFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ProductSliderFragment>()
}
