package io.kotlin.ecommstarter.home.api

import io.kotlin.ecommstarter.home.Block

class ApiUnknownBlock : ApiBlock {

    override fun accept(visitor: ApiBlock.Visitor): Block {
        return Block.EMPTY
    }

}
