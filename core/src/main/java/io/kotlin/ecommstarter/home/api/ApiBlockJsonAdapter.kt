package io.kotlin.ecommstarter.home.api

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

private const val AD_TYPE = "ad"
private const val SLIDER_PRODUCTS_TYPE = "slider_products"
private const val LIST_PRODUCTS_TYPE = "list_products"
private const val GRID_PRODUCTS_TYPE = "grid_products"

class ApiBlockJsonAdapter(moshi: Moshi) : JsonAdapter<ApiBlock>() {

    private val apiItemsAdapter = moshi.adapter<List<ApiProducts>>(Types.newParameterizedType(List::class.java, ApiProducts::class.java))

    companion object {
        fun from(moshi: Moshi): ApiBlockJsonAdapter {
            return ApiBlockJsonAdapter(moshi)
        }
    }

    override fun fromJson(reader: JsonReader): ApiBlock? {
        val data = reader.readJsonValue() as Map<String, Any>
        val type = data["type"] as String
        return when (type) {
            AD_TYPE -> readAdFrom(data)
            SLIDER_PRODUCTS_TYPE, LIST_PRODUCTS_TYPE, GRID_PRODUCTS_TYPE -> readProductFrom(type, data)
            else -> ApiBlock.EMPTY
        }
    }

    private fun readAdFrom(data: Map<String, Any>): ApiAdBlock {
        val id: String = data["id"] as String
        val adImageUrl: String = data["adImageUrl"] as String
        val adUrl: String = data["adUrl"] as String
        val shouldShow: Boolean = data["show"] as Boolean
        val type: String = data["type"] as String
        return ApiAdBlock(id, adImageUrl, adUrl, shouldShow, type)
    }

    private fun readProductFrom(type: String, data: Map<String, Any>): ApiProductBlock {
        val items: List<ApiProducts>? = apiItemsAdapter.fromJsonValue(data["items"])
        return ApiProductBlock(type, items)
    }

    override fun toJson(writer: JsonWriter, value: ApiBlock?) {
        throw UnsupportedOperationException("JSON serialization is not implemented yet")
    }

}
