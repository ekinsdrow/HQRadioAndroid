package com.example.hqradioandroid.data.models

import android.annotation.SuppressLint
import androidx.compose.runtime.compositionLocalOf
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

@SuppressLint("CompositionLocalNaming")
val ConfigLocal = compositionLocalOf<Config> { error("No config") }
