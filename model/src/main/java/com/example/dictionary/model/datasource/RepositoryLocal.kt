package com.example.dictionary.model.datasource

import com.example.dictionary.model.AppState
import com.example.dictionary.model.repository.Repository


interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
