package com.example.dictonary.di

import com.example.dictonary.model.datasource.RoomDataBaseImplementation
import com.example.dictonary.model.repository.Repository
import com.example.dictonary.model.repository.RepositoryImplementation
import com.example.dictonary.model.repository.RetrofitImplementation
import com.example.dictonary.model.repository.entity.DataModel
import com.example.dictonary.view.main.MainInteractor
import com.example.dictonary.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named("Remote")) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>>(named("Local")) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named("Remote")), get(named("Local"))) }
    factory { MainViewModel(get()) }
}