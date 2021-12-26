package com.example.hqradioandroid.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Network(val count: String, val title: String, val name: String)

@Serializable
data class Networks(val list: ArrayList<Network>)