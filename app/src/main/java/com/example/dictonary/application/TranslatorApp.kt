package com.example.dictonary.application

import android.app.Application
import com.example.dictonary.di.AppComponent
import com.example.dictonary.di.DaggerAppComponent

class TranslatorApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appContent(this)
            .build()
    }
}

