package com.example.dictonary.presenter

import com.example.dictonary.model.AppState
import com.example.dictonary.view.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
