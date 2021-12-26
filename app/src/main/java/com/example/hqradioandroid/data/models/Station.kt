package com.example.hqradioandroid.data.models

import kotlinx.serialization.Serializable


@Serializable
data class Station(
    val id: String,
    val title: String,
    val name: String,
    val style: String,
    val genre: String,
    val genreName: String,
    val network: String,
    val networkName: String,
)

@Serializable
data class Stations(val list: ArrayList<Station>)