package com.example.lampochka.domain

import com.example.lampochka.data.BulbRepository
import jakarta.inject.Inject

interface TurnOffUseCase {
    suspend operator fun invoke(): String
}

class TurnOffUseCaseImpl @Inject constructor(
    private  val repository: BulbRepository
): TurnOffUseCase {
    override suspend operator fun invoke(): String{
        val resp = repository.postTurnOff()
        return resp;
    }
}