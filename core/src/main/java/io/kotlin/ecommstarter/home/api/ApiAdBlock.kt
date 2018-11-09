package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.Json
import io.kotlin.ecommstarter.home.Block

data class ApiAdBlock(val id: String,
                      @Json(name = "ad_image_url") val adImageUrl: String,
                      @Json(name = "ad_url") val adUrl: String,
                      @Json(name = "show") val shouldShow: Boolean,
                      val type: String) : ApiBlock {

    override fun accept(visitor: ApiBlock.Visitor): Block {
        return visitor.visit(this)
    }
}
