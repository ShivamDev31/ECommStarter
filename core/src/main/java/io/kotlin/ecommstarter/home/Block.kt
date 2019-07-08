package io.kotlin.ecommstarter.home

interface Block {
    companion object {
        val EMPTY: Block = UnknownBlock()
    }

    fun accept(visitor: Visitor)

    interface Visitor {

        fun visit(sliderProduct: SliderProductBlock)

        fun visit(listProduct: ListProductBlock)

        fun visit(gridProduct: GridProductBlock)

        fun visit(adBlock: AdBlock)
    }
}
