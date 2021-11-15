package com.example.dictonary.di

import com.example.dictonary.view.history.HistoryInteractor
import com.example.dictonary.view.main.MainInteractor
import org.koin.core.qualifier.named
import org.koin.dsl.module

val interactorModule = module {
    factory { HistoryInteractor(get(named("Remote")), get(named("Local"))) }
    factory { MainInteractor(get(named("Remote")), get(named("Local"))) }
}