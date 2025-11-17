package com.example.lampochka.di

import androidx.lifecycle.ViewModel
import com.example.lampochka.di.viewModel.ViewModelModule
import com.example.lampochka.presenter.MainFragment

import dagger.Component
import dagger.Module

@Component(
    modules = [AppModule::class]
)
abstract class AppComponent {
    abstract fun inject(fragment: MainFragment)
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class,
    ]
)
class AppModule