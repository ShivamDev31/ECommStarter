package io.kotlin.ecommstarter.home.api

import io.kotlin.ecommstarter.home.AdBlock
import io.kotlin.ecommstarter.home.Block
import io.kotlin.ecommstarter.home.GridProductBlock
import io.kotlin.ecommstarter.home.HomeBlock
import io.kotlin.ecommstarter.home.ListProductBlock
import io.kotlin.ecommstarter.home.Product
import io.kotlin.ecommstarter.home.SliderProductBlock
import io.kotlin.ecommstarter.rx.Converter
import javax.activation.UnsupportedDataTypeException

class BlockConverter : Converter<ApiHomeBlock?, HomeBlock>, ApiBlock.Visitor {
    override fun apply(apiHomeBlock: ApiHomeBlock): HomeBlock {
        val blocks = mutableListOf<Block>()
        apiHomeBlock.blocks.forEach {
            val block = it.accept(this)
            blocks.add(block)
        }
        return HomeBlock(blocks)
    }

    override fun visit(apiProductBlock: ApiProductBlock): Block {
        val type = apiProductBlock.type
        apiProductBlock.products?.forEach {
            val product = Product(it.id, it.name, it.price, it.imageUrl)
            return when (type) {
                "product_slider" -> SliderProductBlock(product)
                "product_list" -> ListProductBlock(product)
                else -> GridProductBlock(product)
            }
        }

        throw UnsupportedDataTypeException("Unsupported product type not being handled in the app")
    }

    override fun visit(apiAdBlock: ApiAdBlock): Block {
        return AdBlock(apiAdBlock.id, apiAdBlock.adImageUrl, apiAdBlock.adUrl, apiAdBlock.shouldShow, apiAdBlock.type)
    }
}
