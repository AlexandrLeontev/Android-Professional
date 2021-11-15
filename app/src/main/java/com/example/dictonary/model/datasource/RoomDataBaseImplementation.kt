package com.example.dictonary.model.datasource

import com.example.dictonary.model.AppState
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.model.room.DataSourceLocal
import com.example.dictonary.model.room.HistoryDao
import com.example.dictonary.utils.network.convertDataModelSuccessToEntity
import com.example.dictonary.utils.network.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}