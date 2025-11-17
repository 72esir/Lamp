package com.example.lampochka.data

import javax.inject.Inject

interface LampRepository {
    suspend fun postTurnOn(): Boolean
    suspend fun postTurnOff(): Boolean
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
}