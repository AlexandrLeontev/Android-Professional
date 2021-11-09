package com.example.dictonary.model.datasource

interface DataSource<T> {
    suspend fun getData(word: String): T
}
