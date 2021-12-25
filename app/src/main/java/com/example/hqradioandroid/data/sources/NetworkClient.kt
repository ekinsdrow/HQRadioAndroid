package com.example.hqradioandroid.data.sources

import com.example.hqradioandroid.data.models.Config
import retrofit2.http.GET

interface NetworkClient {
    @GET("http://hqradio.ru/config")
    suspend fun getConfig() : Config
}