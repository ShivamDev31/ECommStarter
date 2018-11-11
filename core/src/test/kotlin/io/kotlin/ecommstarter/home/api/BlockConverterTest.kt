package io.kotlin.ecommstarter.home.api

import com.google.common.truth.Truth.assertThat
import io.kotlin.ecommstarter.home.AdBlock
import io.kotlin.ecommstarter.home.GridProductBlock
import io.kotlin.ecommstarter.home.ListProductBlock
import io.kotlin.ecommstarter.home.Product
import io.kotlin.ecommstarter.home.SliderProductBlock
import org.junit.Before
import org.junit.Test
import java.util.*

class BlockConverterTest {

    private val API_AD_BLOCK = ApiAdBlock("id", "image_url", "ad_url", true, "ad")
    private val API_PRODUCT_1 = ApiProducts("id1", "product_1", 1234.5, "image_url")
    private val API_SLIDER_PRODUCT_BLOCK = ApiProductBlock("product_slider", Collections.singletonList(API_PRODUCT_1))
    private val API_LIST_PRODUCT_BLOCK = ApiProductBlock("product_list", Collections.singletonList(API_PRODUCT_1))
    private val API_GRID_PRODUCT_BLOCK = ApiProductBlock("product_grid", Collections.singletonList(API_PRODUCT_1))
    private val PRODUCT = Product("id1", "product_1", 1234.5, "image_url")

    private lateinit var converter: BlockConverter

    @Before
    fun setUp() {
        converter = BlockConverter()
    }

    @Test
    fun `should convert api ad block to correct ad block`() {
        val apiHomeBlock = ApiHomeBlockBuilder()
                .withAdBlock(API_AD_BLOCK)
                .build()

        val homeBlock = converter.apply(apiHomeBlock)

        val adBlock = AdBlock("id", "image_url", "ad_url", true, "ad")
        assertThat(homeBlock.blocks[0]).isEqualTo(adBlock)
    }

    @Test
    fun `should convert api slider product block to slider product block`() {
        val apiHomeBlock = ApiHomeBlockBuilder()
                .withSliderProductBlock(API_SLIDER_PRODUCT_BLOCK)
                .build()

        val homeBlock = converter.apply(apiHomeBlock)

        val productBlock = SliderProductBlock(PRODUCT)
        assertThat(homeBlock.blocks[0]).isEqualTo(productBlock)
    }

    @Test
    fun `should convert api list product block to list product block`() {
        val apiHomeBlock = ApiHomeBlockBuilder()
                .withListProductBlock(API_LIST_PRODUCT_BLOCK)
                .build()

        val homeBlock = converter.apply(apiHomeBlock)

        val productBlock = ListProductBlock(PRODUCT)
        assertThat(homeBlock.blocks[0]).isEqualTo(productBlock)
    }

    @Test
    fun `should convert api grid product block to grid product block`() {
        val apiHomeBlock = ApiHomeBlockBuilder()
                .withGridProductBlock(API_GRID_PRODUCT_BLOCK)
                .build()

        val homeBlock = converter.apply(apiHomeBlock)

        val productBlock = GridProductBlock(PRODUCT)
        assertThat(homeBlock.blocks[0]).isEqualTo(productBlock)
    }
}