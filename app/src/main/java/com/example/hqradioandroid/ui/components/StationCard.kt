package com.example.hqradioandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.hqradioandroid.data.models.Station

@Composable
fun StationCard(station: Station, click: () -> Unit) {
    Surface(
        modifier = Modifier
            .clickable { click() }
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth(),

    ) {
        Row() {
            Image(
                painter = rememberImagePainter(station.getImage()),
                contentDescription = station.title,
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column() {
                Text(text = station.title)
                Text(text = station.network)
                Text(text = station.styleName[0].uppercase() + station.styleName.substring(1))
            }
        }
    }
}