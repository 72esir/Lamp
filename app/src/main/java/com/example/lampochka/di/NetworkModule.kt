package com.example.lampochka.di

import com.example.lampochka.data.LampService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
object NetworkModule {
    @Provides
    fun provideLampService(): LampService =
        Retrofit.Builder()
            .baseUrl("https://192.168.0.100:8000/")
//            .baseUrl("https://restful-booker.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
}