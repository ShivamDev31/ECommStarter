package io.kotlin.common

import io.kotlin.ecommstarter.home.api.BlockConverter
import io.kotlin.ecommstarter.network.JsonDefaults
import io.kotlin.ecommstarter.network.NetworkDefaults

open class BaseIntegrationTest {

    val BLOCK_CONVERTER = BlockConverter()
    //val URL = baseUrl()
    val URL = "https://api.myjson.com/"
    val MOSHI = JsonDefaults.moshi()
    val RETROFIT = NetworkDefaults.retrofit()
            .newBuilder()
            .baseUrl(URL)
            .build()
    val ASSET_LOADER = TestAssetLoader()

//    private fun baseUrl(): String {
//        val properties = Properties()
//        try {
//            properties.load(Resources.getResource("environments/dev.properties").openStream())
//            return properties.getProperty("baseUrl")
//        } catch (e: IOException) {
//            throw RuntimeException(e)
//        }
//        return "https://api.myjson.com/"
//    }

}
