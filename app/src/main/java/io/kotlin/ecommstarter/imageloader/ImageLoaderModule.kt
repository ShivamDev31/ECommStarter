package io.kotlin.ecommstarter.imageloader

import android.app.Application
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageLoaderModule {

    @Provides
    @Singleton
    fun imageLoader(application: Application): ImageLoader {
        return GlideImageLoader.Factory(DiskCacheStrategy.ALL).create(application)
    }
}

