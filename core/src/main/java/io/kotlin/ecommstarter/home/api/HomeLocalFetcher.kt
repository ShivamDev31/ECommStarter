package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import io.kotlin.ecommstarter.home.HomeBlock
import io.kotlin.ecommstarter.common.AssetLoader
import io.reactivex.Single
import okio.Buffer
import java.util.concurrent.Callable

private const val ECOMMERCE_BLOCKS_JSON = "ecommerce.json"

class HomeLocalFetcher(private val blockConverter: BlockConverter,
                       private val assetLoader: AssetLoader,
                       private val apiAdapter: JsonAdapter<ApiHomeBlock>) : HomeFetcher {

    companion object {
        fun from(moshi: Moshi, assetLoader: AssetLoader): HomeLocalFetcher {
            val blockConverter = BlockConverter()
            val adapter = moshi
                    .newBuilder()
                    .build()
                    .adapter<ApiHomeBlock>(ApiHomeBlock::class.java)
            return HomeLocalFetcher(blockConverter, assetLoader, adapter)
        }
    }

    override fun load(): Single<HomeBlock> {
        return Single.fromCallable(readEcommerceBlocksFrom(ECOMMERCE_BLOCKS_JSON))
                .map(blockConverter)
    }

    private fun readEcommerceBlocksFrom(json: String): Callable<ApiHomeBlock?> {
        return Callable {
            val inputStream = assetLoader.loadAsset(json)
            val buffer = Buffer()
            val jsonReader = JsonReader.of(buffer.readFrom(inputStream))
            val apiHomeBlock: ApiHomeBlock? = apiAdapter.fromJson(jsonReader)
            jsonReader.close()
            buffer.close()
            apiHomeBlock
        }
    }


}
