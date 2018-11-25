package io.kotlin.ecommstarter.home

data class GridProductBlock(val products: List<Product>) : Block {

    override fun accept(visitor: Block.Visitor) {
        visitor.visit(this)
    }
}
