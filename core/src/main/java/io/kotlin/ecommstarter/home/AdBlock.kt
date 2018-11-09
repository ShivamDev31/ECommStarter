package io.kotlin.ecommstarter.home

data class AdBlock(val ad: Ad) : Block {

    override fun accept(visitor: Block.Visitor) {
        visitor.visit(this.ad)
    }
}
