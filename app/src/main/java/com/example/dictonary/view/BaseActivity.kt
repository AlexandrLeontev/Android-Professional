package com.example.dictonary.view

import androidx.appcompat.app.AppCompatActivity
import com.example.dictonary.model.AppState
import com.example.dictonary.presenter.Presenter

abstract class BaseActivity<T : AppState> : AppCompatActivity(), View {

    protected val presenter: Presenter<T, View> by lazy {
        createPresenter()
    }

    protected abstract fun createPresenter(): Presenter<T, View>

    abstract override fun renderData(appState: AppState)

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}
