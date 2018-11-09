package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ApiBlockJsonAdapter(moshi: Moshi) : JsonAdapter<ApiBlock>() {

    private val apiItemsAdapter = moshi.adapter<List<ApiProducts>>(Types.newParameterizedType(List::class.java, ApiProducts::class.java))

    companion object {
        fun from(moshi: Moshi): ApiBlockJsonAdapter {
            return ApiBlockJsonAdapter(moshi)
        }
    }

    override fun fromJson(reader: JsonReader): ApiBlock? {
        val data = reader.readJsonValue() as Map<String, Object>
        val type = data["type"] as String
        return when (type) {
            "ad" -> readAdFrom(data)
            else -> readProductFrom(type, data)
        }
    }

    private fun readAdFrom(data: Map<String, Object>): ApiAdBlock {
        val id: String = data["id"] as String
        val adImageUrl: String = data["ad_image_url"] as String
        val adUrl: String = data["ad_url"] as String
        val shouldShow: Boolean = data["show"] as Boolean
        val type: String = data["type"] as String
        return ApiAdBlock(id, adImageUrl, adUrl, shouldShow, type)
    }

    private fun readProductFrom(type: String, data: Map<String, Object>): ApiProductBlock {
//        val id: String = data["id"] as String
//        val name: String = data["name"] as String
//        val price: Double = data["price"] as Double
//        val imageUrl: String = data["image_url"] as String
//        val type: String = data["type"] as String
        val items : List<ApiProducts>? = apiItemsAdapter.fromJsonValue(data["items"])
        return ApiProductBlock(type, items)
    }

    override fun toJson(writer: JsonWriter, value: ApiBlock?) {
        throw UnsupportedOperationException("JSON serialization is not implemented yet")
    }

}
