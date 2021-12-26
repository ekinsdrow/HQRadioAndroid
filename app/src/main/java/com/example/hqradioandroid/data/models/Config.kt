package com.example.hqradioandroid.data.models

import androidx.compose.runtime.compositionLocalOf
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Config(
    @SerialName("genres")
    val genres: Genres,

    @SerialName("styles")
    val styles: Styles,

    @SerialName("networks")
    val networks: Networks,

    @SerialName("stations")
    val stations: Stations,
)

val ConfigLocal = compositionLocalOf<Config> { error("No config") }
