package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import io.kotlin.ecommstarter.home.EcommerceBlock
import io.kotlin.ecommstarter.common.AssetLoader
import io.reactivex.Single
import okio.Buffer
import java.util.concurrent.Callable

private const val ECOMMERCE_BLOCKS_JSON = "ecommerce.json"

class EcommerceLocalFetcher(private val blockConverter: BlockConverter,
                            private val assetLoader: AssetLoader,
                            private val apiAdapter: JsonAdapter<ApiEcommerceBlock>) : EcommerceFetcher {

    companion object {
        fun from(moshi: Moshi, assetLoader: AssetLoader): EcommerceLocalFetcher {
            val blockConverter = BlockConverter()
            val adapter = moshi
                    .newBuilder()
                    .build()
                    .adapter<ApiEcommerceBlock>(ApiEcommerceBlock::class.java)
            return EcommerceLocalFetcher(blockConverter, assetLoader, adapter)
        }
    }

    override fun load(): Single<EcommerceBlock> {
        return Single.fromCallable(readEcommerceBlocksFrom(ECOMMERCE_BLOCKS_JSON))
                .map(blockConverter)
    }

    private fun readEcommerceBlocksFrom(json: String): Callable<ApiEcommerceBlock?> {
        return Callable {
            val inputStream = assetLoader.loadAsset(json)
            val buffer = Buffer()
            val jsonReader = JsonReader.of(buffer.readFrom(inputStream))
            val apiEcommerceBlock: ApiEcommerceBlock? = apiAdapter.fromJson(jsonReader)
            jsonReader.close()
            buffer.close()
            apiEcommerceBlock
        }
    }


}
