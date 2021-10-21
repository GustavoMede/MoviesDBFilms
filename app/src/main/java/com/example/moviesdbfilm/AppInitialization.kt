package com.example.moviesdbfilm

import android.app.Application
import com.example.moviesdbfilm.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppInitialization: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@AppInitialization)
            modules(appModules)
        }
    }
}