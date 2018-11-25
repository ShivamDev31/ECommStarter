package io.kotlin.ecommstarter.home

data class SliderProductBlock(val product: Product): Block {

    override fun accept(visitor: Block.Visitor) {
        visitor.visit(this)
    }
}
