package io.kotlin.ecommstarter.home.api

import io.reactivex.Single
import retrofit2.http.GET

interface EcommerceBackend {

    //@GET("bins/1e802m")
    @GET("bins/10pp4m")
    fun load(): Single<ApiEcommerceBlock>
}
