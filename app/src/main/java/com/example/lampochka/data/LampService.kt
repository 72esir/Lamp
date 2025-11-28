package com.example.lampochka.data

import com.example.lampochka.data.models.GetBrightnessLevelDto
import com.example.lampochka.data.models.GetColorsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LampService {
    @POST("/state/on")
    suspend fun turnOn(): Response<Boolean>

    @POST("/state/off")
    suspend fun turnOff(): Response<Boolean>

    @GET("/brightness/")
    suspend fun getBrightnessLevel() : Response<GetBrightnessLevelDto>

    @POST("/brightness/")
    suspend fun setBrightnessLevel(@Query("level") level: Int) : Response<Boolean>

    @GET("/brightness/current")
    suspend fun getCurrentBrightnessLevel(): Response<Int>

    @GET("/color/")
    suspend fun getColors(): Response<Array<GetColorsDto>>

    @GET("/color/current")
    suspend fun getCurrentColor(): Response<GetColorsDto>

    @GET("/color/names_only")
    suspend fun getColorNamesOnly(): Response<Array<String>>

    @POST("/color/")
    suspend fun setColorName(@Query("color") color: String): Response<Boolean>
}