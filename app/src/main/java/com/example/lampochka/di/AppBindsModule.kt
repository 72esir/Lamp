package com.example.lampochka.di

import com.example.lampochka.data.LampRepository
import com.example.lampochka.data.LampRepositoryImpl
import com.example.lampochka.domain.TurnOffUseCase
import com.example.lampochka.domain.TurnOffUseCaseImpl
import com.example.lampochka.domain.TurnOnUseCase
import com.example.lampochka.domain.TurnOnUseCaseImpl

import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindTurnOnUseCase(impl: TurnOnUseCaseImpl): TurnOnUseCase

    @Binds
    fun bindTurnOffUseCase(impl: TurnOffUseCaseImpl): TurnOffUseCase

    @Binds
    fun bindBulbRepository(impl: LampRepositoryImpl): LampRepository

//    @Binds
//    fun bindGetDogsUseCase(impl: PostBrightnessUseCaseImpl): PostBrightnessUseCase
}