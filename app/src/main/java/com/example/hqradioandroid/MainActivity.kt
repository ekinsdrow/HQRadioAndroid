package com.example.hqradioandroid

import android.R
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hqradioandroid.data.models.Config
import com.example.hqradioandroid.data.models.ConfigLocal
import com.example.hqradioandroid.data.repositories.ConfigRepositoryImpl
import com.example.hqradioandroid.data.repositories.IConfigRepository
import com.example.hqradioandroid.data.sources.NetworkClient
import com.example.hqradioandroid.ui.theme.HqRadioAndroidTheme
import com.example.hqradioandroid.screens.main.MainScreen
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import com.google.gson.GsonBuilder


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://hqradio.ru")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val networkClient = retrofit.create(NetworkClient::class.java)

        val configRepo: IConfigRepository = ConfigRepositoryImpl(
            networkClient
        )

        val viewModel = MainActivityViewModel(configRepo)

        val content: View = findViewById(R.id.content)


        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (viewModel.isReady) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        setContent {
                            CompositionLocalProvider(ConfigLocal provides viewModel.config!!) {
                                HqRadioAndroidTheme {
                                    Surface(color = MaterialTheme.colors.background) {
                                        MainScreen()
                                    }
                                }
                            }
                        }
                        true
                    } else {
                        false
                    }
                }
            }
        )


    }
}

class MainActivityViewModel(private val configRepo: IConfigRepository) : ViewModel() {
    var isReady = false
    var config: Config? = null

    init {
        viewModelScope.launch {
            try {
                config = configRepo.getConfig()
                isReady = true
            } catch (e: Exception) {
                print(e)
                throw e
            }
        }
    }
}
