package com.example.dictonary.model.repository

import com.example.dictonary.model.datasource.DataSource
import com.example.dictonary.model.repository.entity.DataModel
import io.reactivex.rxjava3.core.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
