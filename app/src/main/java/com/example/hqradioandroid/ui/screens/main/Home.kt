package com.example.hqradioandroid.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hqradioandroid.data.models.ConfigLocal
import com.example.hqradioandroid.ui.components.StationsHorizontalListView

@Composable
@Preview
fun HomeScreen() {
    Column() {
        OutlinedTextField(value = "", onValueChange = {})
        Text(text = "Стили")
        Spacer(modifier = Modifier.height(height = 10.dp))
        StationsHorizontalListView(ConfigLocal.current.stations)
    }
}