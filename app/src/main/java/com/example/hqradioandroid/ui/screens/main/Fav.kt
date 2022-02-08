package com.example.hqradioandroid.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hqradioandroid.data.models.ConfigLocal
import com.example.hqradioandroid.ui.components.StationsListView

@Composable
@Preview
fun FavScreen() {
    val config = ConfigLocal.current

    StationsListView(stations = config.stations)
}