package com.example.dictionary.model.datasource

import com.example.dictionary.model.AppState
import com.example.dictionary.model.convertDataModelSuccessToEntity
import com.example.dictionary.model.mapHistoryEntityToSearchResult
import com.example.dictionary.model.repository.entity.DataModel
import com.example.dictionary.model.room.DataSourceLocal
import com.example.dictionary.model.room.HistoryDao

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