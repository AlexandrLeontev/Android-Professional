package com.example.dictonary.di

import com.example.dictonary.view.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainViewModel(get()) }
}