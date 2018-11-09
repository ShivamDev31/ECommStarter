package io.kotlin.ecommstarter.home

class GridProductBlock(val product: Product) : Block {

    override fun accept(visitor: Block.Visitor) {
        visitor.visit(this.product)
    }
}
