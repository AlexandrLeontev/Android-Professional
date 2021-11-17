package com.example.dictionary.model.repository

import com.example.dictionary.model.AppState
import com.example.dictionary.model.datasource.RepositoryLocal
import com.example.dictionary.model.repository.entity.DataModel
import com.example.dictionary.model.room.DataSourceLocal


class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}
