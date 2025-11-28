package com.example.lampochka.data

import com.example.lampochka.data.models.GetBrightnessLevelDto
import com.example.lampochka.data.models.GetColorsDto
import javax.inject.Inject

interface LampRepository {
    suspend fun postTurnOn(): Boolean
    suspend fun postTurnOff(): Boolean
    suspend fun getBrightness(): GetBrightnessLevelDto
    suspend fun getCurrentBrightness(): Int
    suspend fun postBrightness(level: Int): Boolean
    suspend fun getColors(): Array<GetColorsDto>
    suspend fun getCurrentColor(): GetColorsDto
    suspend fun getColorNames(): Array<String>
    suspend fun setColor(color: String): Boolean
}

class LampRepositoryImpl @Inject constructor(
    private  val service: LampService
): LampRepository {
    override suspend fun postTurnOn(): Boolean {
        val response = service.turnOn()
        if (response.isSuccessful){
            return response.body() ?: false
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }

    override suspend fun postTurnOff(): Boolean {
        val response = service.turnOff()
        if (response.isSuccessful) {
            return response.body() ?: false
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }

    override suspend fun getBrightness(): GetBrightnessLevelDto {
        val response = service.getBrightnessLevel()
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Данные яркости отсутствуют")
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }

    override suspend fun getCurrentBrightness(): Int {
        val response = service.getCurrentBrightnessLevel()
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Данные яркости отсутствуют")
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")

    }

    override suspend fun postBrightness(level: Int): Boolean {
        val response = service.setBrightnessLevel(level)
        if (response.isSuccessful){
            return response.body() ?: false
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }

    override suspend fun getColors(): Array<GetColorsDto> {
        val response = service.getColors()
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Данные цветов отсутствуют")
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }

    override suspend fun getCurrentColor(): GetColorsDto {
        val response = service.getCurrentColor()
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Данные текущего цвета отсутствуют")
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }

    override suspend fun getColorNames(): Array<String> {
        val response = service.getColorNamesOnly()
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Цвета не получены")
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }

    override suspend fun setColor(color: String): Boolean {
        val response = service.setColorName(color)
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Цвет не установлен")
        }
        throw Exception("HTTP ${response.code()}: ${response.message()}")
    }
}