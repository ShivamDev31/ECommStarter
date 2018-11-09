package io.kotlin.ecommstarter.home.api

import io.kotlin.ecommstarter.home.Block

data class ApiProductBlock(val type: String, val products: List<ApiProducts>?) : ApiBlock {

    override fun accept(visitor: ApiBlock.Visitor): Block {
        return visitor.visit(this)
    }
}
