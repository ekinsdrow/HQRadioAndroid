package com.example.hqradioandroid.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.hqradioandroid.data.models.Stations

@Composable
fun StationsListView(stations: Stations) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(stations.list.size) {
            StationCard(station = stations.list[it]) {}
        }
    }
}