package com.example.dictonary.view.main

import com.example.dictonary.model.AppState
import com.example.dictonary.model.datasource.RepositoryLocal
import com.example.dictonary.model.repository.Repository
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
