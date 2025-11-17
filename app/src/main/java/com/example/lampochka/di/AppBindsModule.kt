package com.example.lampochka.di

import com.example.lampochka.data.BulbRepository
import com.example.lampochka.data.BulbRepositoryImpl
import com.example.lampochka.data.domain.TurnOffUseCase
import com.example.lampochka.data.domain.TurnOffUseCaseImpl
import com.example.lampochka.data.domain.TurnOnUseCase
import com.example.lampochka.data.domain.TurnOnUseCaseImpl

import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindPostTurnOnUseCase(impl: TurnOnUseCaseImpl): TurnOnUseCase

    @Binds
    fun bindPostTurnOffUseCase(impl: TurnOffUseCaseImpl): TurnOffUseCase

    @Binds
    fun bindBulbRepository(impl: BulbRepositoryImpl): BulbRepository

//    @Binds
//    fun bindGetDogsUseCase(impl: PostBrightnessUseCaseImpl): PostBrightnessUseCase
}