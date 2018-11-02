package io.kotlin.ecommstarter.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class NetworkDefaults {

    companion object {
        private const val DEFAULT_TIMEOUT = 30L

        fun okHttpClient(): OkHttpClient {
            return OkHttpClientHolder.INSTANCE.okHttpClient
        }
    }

    private enum class OkHttpClientHolder {
        INSTANCE;

        val okHttpClient = defaultOkHttpClient()

        private fun defaultOkHttpClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor())
            return builder.build()
        }

        private fun loggingInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return loggingInterceptor
        }

    }

}
