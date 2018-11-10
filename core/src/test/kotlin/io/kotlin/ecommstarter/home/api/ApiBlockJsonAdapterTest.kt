package io.kotlin.ecommstarter.home.api

import com.google.common.truth.Truth.assertThat
import io.kotlin.ecommstarter.network.JsonDefaults
import io.kotlin.ecommstarter.test.TestResources.Companion.jsonReaderFrom
import org.junit.Before
import org.junit.Test


class ApiBlockJsonAdapterTest {


    private lateinit var apiBlockJsonAdapter: ApiBlockJsonAdapter

    @Before
    fun setUp() {
        apiBlockJsonAdapter = ApiBlockJsonAdapter(JsonDefaults.moshi())
    }

    @Test
    fun `should parse ad block correctly`() {
        val apiAdBlock: ApiAdBlock = apiBlockJsonAdapter.fromJson(jsonReaderFrom("ad_block.json")) as ApiAdBlock
        assertThat(apiAdBlock.id).isEqualTo("ad")
        assertThat(apiAdBlock.adImageUrl).isEqualTo("https://ad.link")
        assertThat(apiAdBlock.adUrl).isEqualTo("URL")
        assertThat(apiAdBlock.shouldShow).isEqualTo(true)
    }

    @Test
    fun `should parse product slider block correctly`() {
        val apiProductBlock: ApiProductBlock = apiBlockJsonAdapter.fromJson(jsonReaderFrom("product_slider_block.json")) as ApiProductBlock
        assertThat(apiProductBlock.products?.get(0)?.id).isEqualTo("111")
        assertThat(apiProductBlock.products?.get(0)?.name).isEqualTo("Puma Men's Running Shoes")
        assertThat(apiProductBlock.products?.get(0)?.price).isEqualTo(1554.5)
        assertThat(apiProductBlock.products?.get(0)?.imageUrl).isEqualTo("https://product.link")
    }

    @Test
    fun `should parse product list block correctly`() {
        val apiProductBlock: ApiProductBlock = apiBlockJsonAdapter.fromJson(jsonReaderFrom("product_list_block.json")) as ApiProductBlock
        assertThat(apiProductBlock.products?.get(0)?.id).isEqualTo("211")
        assertThat(apiProductBlock.products?.get(0)?.name).isEqualTo("Carlton London Mr.CL Casuals For Men  (Navy)")
        assertThat(apiProductBlock.products?.get(0)?.price).isEqualTo(1332.5)
        assertThat(apiProductBlock.products?.get(0)?.imageUrl).isEqualTo("https://product.link")
    }

    @Test
    fun `should parse product grid block correctly`() {
        val apiProductBlock: ApiProductBlock = apiBlockJsonAdapter.fromJson(jsonReaderFrom("product_grid_block.json")) as ApiProductBlock
        assertThat(apiProductBlock.products?.get(0)?.id).isEqualTo("311")
        assertThat(apiProductBlock.products?.get(0)?.name).isEqualTo("Butterfly Smart 750-Watt Mixer Grinder with 4 Jar (Grey)")
        assertThat(apiProductBlock.products?.get(0)?.price).isEqualTo(3399.0)
        assertThat(apiProductBlock.products?.get(0)?.imageUrl).isEqualTo("https://product.link")
    }
}
