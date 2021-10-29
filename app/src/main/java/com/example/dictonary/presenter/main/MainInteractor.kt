package com.example.dictonary.presenter.main

import com.example.dictonary.model.AppState
import com.example.dictonary.model.repository.Repository
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.presenter.Interactor
import io.reactivex.rxjava3.core.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
