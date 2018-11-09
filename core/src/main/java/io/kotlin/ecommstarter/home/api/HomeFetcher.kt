package io.kotlin.ecommstarter.home.api

import io.kotlin.ecommstarter.home.HomeBlock
import io.reactivex.Single

interface HomeFetcher {

    fun load(): Single<HomeBlock>
}
