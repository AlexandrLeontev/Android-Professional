package com.example.dictonary.di

import com.example.dictonary.view.main.MainInteractor
import org.koin.core.qualifier.named
import org.koin.dsl.module

val interactorModule = module {
    factory { MainInteractor(get(named("Remote")), get(named("Local"))) }
}