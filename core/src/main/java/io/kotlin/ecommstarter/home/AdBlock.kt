package io.kotlin.ecommstarter.home

data class AdBlock(val id: String,
                   val adImageUrl: String,
                   val adUrl: String,
                   val shouldShow: Boolean,
                   val type: String) : Block {

    override fun accept(visitor: Block.Visitor) {
        visitor.visit(this)
    }
}
