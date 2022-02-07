package com.example.hqradioandroid.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.hqradioandroid.data.models.Stations

@Composable
fun StationsHorizontalListView(stations: Stations) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(stations.list.size) {
            StationSquareCard(station = stations.list[it], {})
        }
    }
}