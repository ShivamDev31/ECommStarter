package io.kotlin.ecommstarter.home.api

import io.kotlin.ecommstarter.home.Block

interface ApiBlock {

    companion object {
        val EMPTY = ApiUnknownBlock()
    }

    fun accept(visitor: Visitor): Block

    interface Visitor {
        fun visit(apiProductBlock: ApiProductBlock): Block

        fun visit(apiAdBlock: ApiAdBlock): Block
    }

}
