package com.example.hqradioandroid.data.models

import androidx.compose.runtime.compositionLocalOf
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val genres: Genres,
    val styles: Styles,
    val networks: Networks,
    val stations: Stations,
    val new: StationIdList,
    val hot: StationIdList,
)

val ConfigLocal = compositionLocalOf<Config> { error("No config") }
