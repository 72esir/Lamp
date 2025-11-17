package com.example.lampochka.di

import com.example.lampochka.data.BulbService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
object NetworkModule {
    @Provides
    fun provideBulbService(): BulbService =
        Retrofit.Builder()
            .baseUrl("https://192.168.0.100:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
}