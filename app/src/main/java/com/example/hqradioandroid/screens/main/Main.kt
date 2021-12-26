package com.example.hqradioandroid.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.tooling.preview.Preview
import com.example.hqradioandroid.R
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier

@Composable
@Preview
fun MainScreen() {
    val mainScreenNavController = rememberNavController()

    Scaffold(bottomBar = {
        BottomAppBar {
            var index by remember { mutableStateOf(0) }

            for (i in 0..2) {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            when (i) {
                                0 -> Icons.Filled.MusicNote
                                1 -> Icons.Filled.Favorite
                                2 -> Icons.Filled.Settings
                                else -> Icons.Filled.MusicNote
                            }, ""
                        )
                    },
                    label = { Text(text = stringResource(id = R.string.favorites)) },
                    selected = index == i,
                    onClick = {
                        index = i
                        mainScreenNavController.navigate(
                            when (i) {
                                0 -> "home"
                                1 -> "fav"
                                2 -> "settings"
                                else -> "home"
                            },
                        )
                    },
                    alwaysShowLabel = true
                )
            }

        }
    }) {
        Box(modifier = Modifier.padding(16.dp)) {
            NavHost(navController = mainScreenNavController, startDestination = "home") {
                composable("home") { HomeScreen() }
                composable("fav") { FavScreen() }
                composable("settings") { SettingsScreen() }
            }
        }
    }
}