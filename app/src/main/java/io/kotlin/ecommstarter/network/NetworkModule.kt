package io.kotlin.ecommstarter.network

import android.app.Application
import dagger.Module
import dagger.Provides
import io.kotlin.ecommstarter.BuildConfig
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import javax.inject.Singleton

private const val DEFAULT_DISK_CACHE_SIZE = 16 * 1024 * 1024 // 16MB

@Singleton
@Module
class NetworkModule(application: Application) {

    private val defaultCache = Cache(createCache(application, "default_cache"), DEFAULT_DISK_CACHE_SIZE.toLong())

    private fun createCache(application: Application, defaultCache: String): File {
        return File(application.cacheDir, defaultCache)
    }

    @Provides
    @Singleton
    fun baseUrl(): HttpUrl {
        return HttpUrl.get(BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun retrofitWithDefaultCache(httpUrl: HttpUrl): Retrofit {
        return NetworkDefaults.retrofit()
                .newBuilder()
                .client(newOkHttpClient())
                .baseUrl(httpUrl)
                .build()
    }

    private fun newOkHttpClient(): OkHttpClient {
        val okHttpClient = NetworkDefaults.okHttpClient()
                .newBuilder()
                .cache(defaultCache)
        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(httpLoggingInterceptor())
        }
        return okHttpClient.build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val okHttpLoggingInterceptor = HttpLoggingInterceptor()
        okHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return okHttpLoggingInterceptor
    }

}
