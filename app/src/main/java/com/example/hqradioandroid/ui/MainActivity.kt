package com.example.hqradioandroid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hqradioandroid.HqRadioApplication
import com.example.hqradioandroid.ui.screens.main.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = (application as HqRadioApplication).appContainer

        setContent {
            HqRadio(appContainer = appContainer)
        }
    }
}
