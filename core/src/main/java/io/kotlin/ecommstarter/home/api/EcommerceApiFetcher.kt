package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.Moshi
import io.kotlin.ecommstarter.home.EcommerceBlock
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class EcommerceApiFetcher(private val blockConverter: BlockConverter, private val backend: EcommerceBackend) : EcommerceFetcher {

    companion object {
        fun from(retrofit: Retrofit, moshi: Moshi): EcommerceApiFetcher {
            val blockConverter = BlockConverter()

            val localMoshi = moshi.newBuilder()
                    .add(ApiBlock::class.java, ApiBlockJsonAdapter(moshi))
                    .build()

            val ecommerceBackend = retrofit
                    .newBuilder()
                    .addConverterFactory(MoshiConverterFactory.create(localMoshi))
                    .build()
                    .create(EcommerceBackend::class.java)
            return EcommerceApiFetcher(blockConverter, ecommerceBackend)
        }
    }

    override fun load(): Single<EcommerceBlock> {
        return backend
                .load()
                .map(blockConverter)
    }

}
