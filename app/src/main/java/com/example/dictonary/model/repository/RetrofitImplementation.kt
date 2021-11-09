package com.example.dictonary.model.repository

import com.example.dictonary.model.datasource.DataSource
import com.example.dictonary.model.repository.entity.DataModel

class RetrofitImplementation(private val apiService: ApiService) : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return apiService.search(word)
    }

    companion object {
        const val BASE_URL_LOCATIONS = "https://dictionary.skyeng.ru/api/public/v1/"
    }
}
