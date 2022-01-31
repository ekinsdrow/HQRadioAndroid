package com.example.hqradioandroid.data.models

import kotlinx.serialization.Serializable

@Serializable
data class StationId(val id: String)

@Serializable
data class StationIdList(val list: ArrayList<StationId>)