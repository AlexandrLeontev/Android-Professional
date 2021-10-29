package com.example.dictonary.model.datasource

import com.example.dictonary.model.repository.RetrofitImplementation
import com.example.dictonary.model.repository.entity.DataModel
import io.reactivex.rxjava3.core.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
