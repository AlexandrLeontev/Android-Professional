package com.example.dictonary.model.repository

import com.example.dictonary.model.AppState
import com.example.dictonary.model.datasource.RepositoryLocal
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.model.room.DataSourceLocal

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}