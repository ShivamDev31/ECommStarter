package io.kotlin.ecommstarter.common

import java.io.IOException
import java.io.InputStream

interface AssetLoader {

    @Throws(IOException::class)
    fun loadAsset(assetName: String): InputStream
}
