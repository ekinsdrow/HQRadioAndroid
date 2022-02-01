package com.example.hqradioandroid.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val style: String,
    @SerializedName("style_name")
    val styleName: String,
    val title: String,
    val name: String,
)

@Serializable
data class Genres(val list: ArrayList<Genre>)