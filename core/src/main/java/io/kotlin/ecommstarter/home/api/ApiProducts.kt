package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.Json

data class ApiProducts(val id: String,
                       val name: String,
                       val price: Double,
                       @Json(name = "image_url") val imageUrl: String)
