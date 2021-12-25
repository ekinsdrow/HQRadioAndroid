package com.example.hqradioandroid.data.repositories

import com.example.hqradioandroid.data.models.Config
import com.example.hqradioandroid.data.sources.NetworkClient

class ConfigRepositoryImpl constructor(
    private val networkClient: NetworkClient,
) : IConfigRepository {
    override suspend fun getConfig(): Config = networkClient.getConfig()
}