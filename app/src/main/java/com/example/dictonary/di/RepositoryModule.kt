package com.example.dictonary.di

import com.example.dictonary.model.datasource.RoomDataBaseImplementation
import com.example.dictonary.model.repository.Repository
import com.example.dictonary.model.repository.RepositoryImplementation
import com.example.dictonary.model.repository.RetrofitImplementation
import com.example.dictonary.model.repository.entity.DataModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository<List<DataModel>>>(named("Remote")) {
        RepositoryImplementation(
            RetrofitImplementation(get())
        )
    }
    single<Repository<List<DataModel>>>(named("Local")) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}