package com.example.hqradioandroid.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeScreen() {
    Column() {
        OutlinedTextField(value = "", onValueChange = {})
        Text(text = "Стили")
    }
}