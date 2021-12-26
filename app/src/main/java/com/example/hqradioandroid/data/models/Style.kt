package com.example.hqradioandroid.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Style(val title: String, val name: String)

@Serializable
data class Styles(val list: ArrayList<Style>)