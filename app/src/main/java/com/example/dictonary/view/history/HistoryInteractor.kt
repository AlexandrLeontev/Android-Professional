package com.example.dictonary.view.history

import com.example.dictonary.model.AppState
import com.example.dictonary.model.datasource.RepositoryLocal
import com.example.dictonary.model.repository.Repository
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
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