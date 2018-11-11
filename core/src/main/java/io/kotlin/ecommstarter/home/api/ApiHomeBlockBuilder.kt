package io.kotlin.ecommstarter.home.api

class ApiHomeBlockBuilder {

    private val blocks = mutableListOf<ApiBlock>()

    fun withAdBlock(adBlock: ApiAdBlock): ApiHomeBlockBuilder {
        blocks.add(adBlock)
        return this
    }

    fun withSliderProductBlock(apiProductBlock: ApiProductBlock): ApiHomeBlockBuilder {
        blocks.add(apiProductBlock)
        return this
    }

    fun withListProductBlock(apiProductBlock: ApiProductBlock): ApiHomeBlockBuilder {
        blocks.add(apiProductBlock)
        return this
    }

    fun withGridProductBlock(apiProductBlock: ApiProductBlock): ApiHomeBlockBuilder {
        blocks.add(apiProductBlock)
        return this
    }

    fun build(): ApiHomeBlock {
        return ApiHomeBlock(blocks)
    }

}
