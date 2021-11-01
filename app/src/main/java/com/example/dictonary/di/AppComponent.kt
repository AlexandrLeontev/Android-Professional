package com.example.dictonary.di

import android.content.Context
import com.example.dictonary.view.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        ViewModelModule::class]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContent(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
}
