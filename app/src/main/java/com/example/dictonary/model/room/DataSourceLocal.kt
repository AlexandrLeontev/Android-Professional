package com.example.dictonary.model.room

import com.example.dictonary.model.AppState
import com.example.dictonary.model.datasource.DataSource

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}