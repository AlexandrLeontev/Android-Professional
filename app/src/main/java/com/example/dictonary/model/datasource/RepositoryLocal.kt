package com.example.dictonary.model.datasource

import com.example.dictonary.model.AppState
import com.example.dictonary.model.repository.Repository

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}