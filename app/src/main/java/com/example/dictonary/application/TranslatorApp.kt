package com.example.dictonary.application

import android.app.Application
import com.example.dictonary.di.*
import org.koin.core.context.startKoin

class TranslatorApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, interactorModule, repositoryModule, viewModelModule))
        }
    }
}

