package com.example.hqradioandroid.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Genre(val style: String, val styleName: String, val title: String, val name: String)

@Serializable
data class Genres(val list: ArrayList<Genre>)