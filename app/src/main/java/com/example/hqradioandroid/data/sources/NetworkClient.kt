package com.example.hqradioandroid.data.sources

import com.example.hqradioandroid.data.models.Config
import retrofit2.http.GET
import retrofit2.http.Headers

interface NetworkClient {
    @Headers("Accept: application/json")
    @GET("/config?ajax=json")
    suspend fun getConfig() : Config
}