package com.solanacode.makeupapi.api

import com.solanacode.makeupapi.model.MakeUpItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("products.json")
    fun getAllProduct(): Call<List<MakeUpItem>>
}