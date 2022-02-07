package com.example.hqradioandroid.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.hqradioandroid.data.models.ConfigLocal
import com.example.hqradioandroid.data.models.Networks
import com.example.hqradioandroid.data.models.Styles
import com.example.hqradioandroid.utils.ColorUtil

@Composable
@Preview
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val config = ConfigLocal.current
        Search()
        Spacer(modifier = Modifier.height(20.dp))
        Styles(styles = config.styles)
        Spacer(modifier = Modifier.height(height = 20.dp))
        Networks(networks = config.networks)
    }
}

@Composable
private fun Search() {
    OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())
}

@Composable
private fun Styles(styles: Styles) {
    Text(text = "Стили")
    Spacer(modifier = Modifier.height(height = 10.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(styles.list.size) {
            val style = styles.list[it]
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(ColorUtil.getColorByName(style.name))
                    .padding(horizontal = 40.dp, vertical = 10.dp)
            ) {
                Text(text = style.title)
            }
        }
    }
}

@Composable
private fun Networks(networks: Networks) {
    Text(text = "Сети")
    Spacer(modifier = Modifier.height(height = 10.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(networks.list.size) {
            val network = networks.list[it]
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(88, 88, 88, 100))
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        //TODO: inject mainUrl from AppContainer
                        painter = rememberImagePainter(network.getImage("http://hqradio.ru/")),
                        contentDescription = network.title,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = network.title)
                }
            }
        }
    }
}