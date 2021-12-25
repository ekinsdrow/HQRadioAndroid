package com.example.hqradioandroid.screens.main

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

@Composable
@Preview
fun MainScreen() {
    Scaffold(bottomBar = {
        BottomAppBar() {
            var index by remember { mutableStateOf(0) }

            BottomNavigationItem(
                icon = {
                    Icon(Icons.Filled.MusicNote, "")
                },
                label = { Text(text = stringResource(id = R.string.favorites)) },
                selected = index == 0,
                onClick = {
                    index = 0
                },
                alwaysShowLabel = true
            )

            BottomNavigationItem(
                icon = {
                    Icon(Icons.Filled.Favorite, "")
                },
                label = { Text(text = stringResource(id = R.string.favorites)) },
                selected = index == 1,
                onClick = {
                    index = 1
                },
                alwaysShowLabel = true
            )

            BottomNavigationItem(
                icon = {
                    Icon(Icons.Filled.Settings, "")
                },
                label = { Text(text = stringResource(id = R.string.settings)) },
                selected = index == 2,
                onClick = {
                    index = 2
                },
                alwaysShowLabel = true
            )
        }
    }) {}
}