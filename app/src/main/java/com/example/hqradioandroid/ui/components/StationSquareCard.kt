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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.hqradioandroid.data.models.Station

@Composable
fun StationSquareCard(station: Station, click: () -> Unit) {
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { click() }
            .fillMaxWidth()
    ) {
        Column() {
            Image(
                //TODO: inject mainUrl from AppContainer
                painter = rememberImagePainter(station.getImage("http://hqradio.ru/")),
                contentDescription = station.title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier.width(width = 80.dp)
            ) {
                Text(text = station.title, overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}