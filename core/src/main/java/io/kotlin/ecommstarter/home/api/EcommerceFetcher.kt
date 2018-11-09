package io.kotlin.ecommstarter.home.api

import io.kotlin.ecommstarter.home.EcommerceBlock
import io.reactivex.Single

interface EcommerceFetcher {

    fun load(): Single<EcommerceBlock>
}
