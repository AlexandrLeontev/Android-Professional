package com.example.dictonary.view.main

import com.example.dictonary.di.NAME_LOCAL
import com.example.dictonary.di.NAME_REMOTE
import com.example.dictonary.model.AppState
import com.example.dictonary.model.repository.Repository
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.viewmodel.Interactor
import io.reactivex.rxjava3.core.Observable
import javax.inject.Named

class MainInteractor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}
