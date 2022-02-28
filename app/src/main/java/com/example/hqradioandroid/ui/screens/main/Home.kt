package com.example.hqradioandroid.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.hqradioandroid.data.models.*
import com.example.hqradioandroid.ui.components.StationsHorizontalListView
import com.example.hqradioandroid.ui.components.StationsListView
import com.example.hqradioandroid.utils.ColorUtil

@Composable
@Preview
fun HomeScreen() {
    val config = ConfigLocal.current
    var searchValue by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(bottom = 60.dp)) {
        SearchField(
            searchValue,
            callback = {
                searchValue = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (searchValue == "") {
            MainBody(config = config)
        } else {
            StationsListView(stations = config.stations.getStationByString(searchValue))
        }
    }
}

@Composable
private fun SearchField(searchValue: String, callback: (String) -> Unit) {
    OutlinedTextField(
        value = searchValue,
        onValueChange = callback,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun MainBody(config: Config) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())

    ) {
        Styles(styles = config.styles)
        Spacer(modifier = Modifier.height(height = 20.dp))
        Networks(networks = config.networks)
        Spacer(modifier = Modifier.height(height = 40.dp))
        ListOfStations(
            stations = config.stations.getStationsListByStationIdList(config.new),
            title = "Новое"
        )
        Spacer(modifier = Modifier.height(height = 40.dp))
        ListOfStations(
            stations = config.stations.getStationsListByStationIdList(config.hot),
            title = "Популярное"
        )

    }
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


@Composable
private fun ListOfStations(stations: Stations, title: String) {
    Text(text = title)
    Spacer(modifier = Modifier.height(height = 10.dp))
    StationsHorizontalListView(stations = stations)
}