package io.kotlin.ecommstarter.network

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class JsonModule {

    @Singleton
    @Provides
    fun mosho(): Moshi {
        return JsonDefaults.moshi()
    }

}
