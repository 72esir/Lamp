package com.example.lampochka.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface BulbService {
//    @POST()
//    suspend fun postBrightness(brightnessLevel: Int)

    @POST("/state/on")
    suspend fun postTurnOn()

    @POST("/state/off")
    suspend fun postTurnOff()
}