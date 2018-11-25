package io.kotlin.ecommstarter.home

data class ListProductBlock(val product: Product) : Block {

    override fun accept(visitor: Block.Visitor) {
        visitor.visit(this)
    }
}
