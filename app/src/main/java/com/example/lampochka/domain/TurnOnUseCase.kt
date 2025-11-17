package com.example.lampochka.domain

import com.example.lampochka.data.BulbRepository
import jakarta.inject.Inject

interface TurnOnUseCase {
    suspend operator fun invoke(): String
}

class TurnOnUseCaseImpl @Inject constructor(
    private  val repository: BulbRepository
): TurnOnUseCase {
    override suspend operator fun invoke() =
        repository.postTurnOn()
}