package com.example.dictonary.view

import com.example.dictonary.model.AppState

interface View {

    fun renderData(appState: AppState)
}
