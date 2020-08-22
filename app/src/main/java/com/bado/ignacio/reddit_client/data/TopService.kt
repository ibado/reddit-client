package com.bado.ignacio.reddit_client.data

import retrofit2.http.GET
import retrofit2.http.Headers

interface TopService {

    @GET("top")
    @Headers("Content-Type: application/json")
    suspend fun getTop(): TopResponse
}
