package com.example.lampochka.data

import javax.inject.Inject

interface BulbRepository {
//    suspend fun postBrightnessLevel(brightnessLevel: Int): PostBrightnessLevel?

    suspend fun postTurnOn(): String
    suspend fun postTurnOff(): String
}

class BulbRepositoryImpl @Inject constructor(
    private  val service: BulbService
): BulbRepository {
    override suspend fun postTurnOn(): String {
        val resp = service.postTurnOn()
        return resp.toString();
    }

    override suspend fun postTurnOff(): String {
        val resp = service.postTurnOff()
        return resp.toString();
    }
}