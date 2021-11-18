package net.example.android.dictionary.viewmodel

interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}