package com.example.dictonary.model.repository

interface Repository<T> {
    suspend fun getData(word: String): T
}
