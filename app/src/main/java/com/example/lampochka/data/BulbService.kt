package com.example.lampochka.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface BulbService {

    @GET("/ping")
    suspend fun postTurnOn(): String

    @GET("/ping") //state/off
    suspend fun postTurnOff(): String
}