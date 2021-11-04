package com.example.dictonary.view.main

import com.example.dictonary.model.AppState
import com.example.dictonary.model.repository.Repository
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}