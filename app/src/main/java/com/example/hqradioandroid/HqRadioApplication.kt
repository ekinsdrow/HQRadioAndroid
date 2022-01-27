package com.example.hqradioandroid

import android.app.Application
import com.example.hqradioandroid.data.AppContainer

class HqRadioApplication : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()

        appContainer = AppContainer()
    }
}