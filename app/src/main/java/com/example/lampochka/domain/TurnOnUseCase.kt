package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import jakarta.inject.Inject

interface TurnOnUseCase {
    suspend operator fun invoke(): Boolean
}

class TurnOnUseCaseImpl @Inject constructor(
    private  val repository: LampRepository
): TurnOnUseCase {
    override suspend operator fun invoke() = repository.postTurnOn()
}