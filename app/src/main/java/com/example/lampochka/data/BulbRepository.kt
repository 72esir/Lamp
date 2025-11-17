package com.example.lampochka.data

import javax.inject.Inject

interface BulbRepository {
//    suspend fun postBrightnessLevel(brightnessLevel: Int): PostBrightnessLevel?

    suspend fun postTurnOn()
    suspend fun postTurnOff()
}

class BulbRepositoryImpl @Inject constructor(
    private  val service: BulbService
): BulbRepository {
    override suspend fun postTurnOn() {
        val resp = service.postTurnOn()
    }

    override suspend fun postTurnOff() {
        val resp = service.postTurnOff()
    }
}