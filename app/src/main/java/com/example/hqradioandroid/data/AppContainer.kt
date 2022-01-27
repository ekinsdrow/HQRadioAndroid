package com.example.hqradioandroid.data

import android.content.Context
import com.example.hqradioandroid.data.repositories.ConfigRepositoryImpl
import com.example.hqradioandroid.data.repositories.IConfigRepository
import com.example.hqradioandroid.data.sources.NetworkClient
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer() {
    val configRepository: IConfigRepository by lazy {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://hqradio.ru")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val networkClient = retrofit.create(NetworkClient::class.java)

        ConfigRepositoryImpl(networkClient)
    }
}