package com.seankim.zomatosearchex.API


import com.seankim.zomatosearchex.Model.SearchResponseModel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ZomatoAPI {
    @GET("api/v2.1/geocode")
    @Headers("Accept: application/json", "user-key: 798640246aa45163ec1645f557915471")
    fun query(
            @Query("lat") lat: String,
            @Query("lon") lon: String
    ): Call<SearchResponseModel>
}
