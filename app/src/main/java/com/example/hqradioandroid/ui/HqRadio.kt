package com.example.hqradioandroid.ui

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hqradioandroid.data.AppContainer
import com.example.hqradioandroid.data.models.Config
import com.example.hqradioandroid.data.models.ConfigLocal
import com.example.hqradioandroid.data.repositories.IConfigRepository
import com.example.hqradioandroid.ui.components.Loader
import com.example.hqradioandroid.ui.screens.main.MainScreen
import com.example.hqradioandroid.ui.theme.HqRadioAndroidTheme
import kotlinx.coroutines.launch

@Composable
fun HqRadio(appContainer: AppContainer) {
    val viewModel = HqRadioViewModel(appContainer.configRepository)
    val state = viewModel.uiState

    HqRadioAndroidTheme {
        Surface(color = MaterialTheme.colors.background) {
            if (state.value == null) {
                Loader()
            } else {
                CompositionLocalProvider(ConfigLocal provides state.value!!) {
                    MainScreen()
                }
            }
        }
    }
}


class HqRadioViewModel(configRepository: IConfigRepository) : ViewModel() {

    var uiState = mutableStateOf<Config?>(null)

    init {
        viewModelScope.launch {
            try {
                uiState.value = configRepository.getConfig()
            } catch (e: Exception) {
                //TODO: throw
                print(e)
            }
        }
    }
}