package io.kotlin.ecommstarter.home

interface Block {
    companion object {
        val EMPTY: Block = UnknownBlock()
    }

    fun accept(visitor: Visitor)

    interface Visitor {

        fun visit(product: Product)

        fun visit(adBlock: AdBlock)
    }
}
