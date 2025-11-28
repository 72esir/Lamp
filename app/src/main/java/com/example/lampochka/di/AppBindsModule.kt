package com.example.lampochka.di

import com.example.lampochka.data.LampRepository
import com.example.lampochka.data.LampRepositoryImpl
import com.example.lampochka.domain.GetBrightnessUseCase
import com.example.lampochka.domain.GetBrightnessUseCaseImpl
import com.example.lampochka.domain.GetColorNamesUseCase
import com.example.lampochka.domain.GetColorNamesUseCaseImpl
import com.example.lampochka.domain.GetColorsUseCase
import com.example.lampochka.domain.GetColorsUseCaseImpl
import com.example.lampochka.domain.GetCurrentBrightnessUseCase
import com.example.lampochka.domain.GetCurrentBrightnessUseCaseImpl
import com.example.lampochka.domain.GetCurrentColorUseCase
import com.example.lampochka.domain.GetCurrentColorUseCaseImpl
import com.example.lampochka.domain.PostBrightnessUseCase
import com.example.lampochka.domain.PostBrightnessUseCaseImpl
import com.example.lampochka.domain.PostColorUseCase
import com.example.lampochka.domain.PostColorUseCaseImpl
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
    fun bindGetBrightnessUseCase(impl: GetBrightnessUseCaseImpl): GetBrightnessUseCase

    @Binds
    fun bindGetCurrBrightnessUseCase(impl: GetCurrentBrightnessUseCaseImpl): GetCurrentBrightnessUseCase

    @Binds
    fun bindGetColorsUseCase(impl: GetColorsUseCaseImpl): GetColorsUseCase

    @Binds
    fun bindGetCurrColorUseCase(impl: GetCurrentColorUseCaseImpl): GetCurrentColorUseCase

    @Binds
    fun bindGetColorNamesUseCase(impl: GetColorNamesUseCaseImpl): GetColorNamesUseCase

    @Binds
    fun bindPostBrightnessUseCase(impl: PostBrightnessUseCaseImpl): PostBrightnessUseCase

    @Binds
    fun bindPostColorUseCase(impl: PostColorUseCaseImpl): PostColorUseCase

    @Binds
    fun bindLampRepository(impl: LampRepositoryImpl): LampRepository
}