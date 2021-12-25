package com.example.hqradioandroid.data.repositories

import com.example.hqradioandroid.data.models.Config

interface IConfigRepository {
    suspend fun getConfig(): Config
}