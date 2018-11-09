package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.Moshi
import io.kotlin.ecommstarter.home.HomeBlock
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HomeApiFetcher(private val blockConverter: BlockConverter, private val backend: HomeBackend) : HomeFetcher {

    companion object {
        fun from(retrofit: Retrofit, moshi: Moshi): HomeApiFetcher {
            val blockConverter = BlockConverter()

            val localMoshi = moshi.newBuilder()
                    .add(ApiBlock::class.java, ApiBlockJsonAdapter(moshi))
                    .build()

            val ecommerceBackend = retrofit
                    .newBuilder()
                    .addConverterFactory(MoshiConverterFactory.create(localMoshi))
                    .build()
                    .create(HomeBackend::class.java)
            return HomeApiFetcher(blockConverter, ecommerceBackend)
        }
    }

    override fun load(): Single<HomeBlock> {
        return backend
                .load()
                .map(blockConverter)
    }

}
