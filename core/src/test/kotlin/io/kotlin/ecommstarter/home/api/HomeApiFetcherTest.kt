package io.kotlin.ecommstarter.home.api

import io.kotlin.common.BaseIntegrationTest
import org.junit.Test

class HomeApiFetcherTest : BaseIntegrationTest() {

    @Test
    fun `should load home data from api`() {
        val homeApiFetcher: HomeApiFetcher = HomeApiFetcher.from(RETROFIT, MOSHI)

        val testObserver = homeApiFetcher.load().test()

        testObserver.assertComplete()
        testObserver.assertValueCount(1)
    }
}