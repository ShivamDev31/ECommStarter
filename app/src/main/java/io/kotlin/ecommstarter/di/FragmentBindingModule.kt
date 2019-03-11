package io.kotlin.ecommstarter.di

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import io.kotlin.ecommstarter.home.productslider.ProductSliderFragment
import io.kotlin.ecommstarter.home.productslider.ProductSliderFragmentInjector

@Module(subcomponents = [ProductSliderFragmentInjector::class])
interface FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(ProductSliderFragment::class)
    fun bindArticleFragment(builder: ProductSliderFragmentInjector.Builder): AndroidInjector.Factory<out Fragment>

}
