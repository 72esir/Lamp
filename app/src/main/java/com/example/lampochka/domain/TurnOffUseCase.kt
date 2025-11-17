package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import jakarta.inject.Inject

interface TurnOffUseCase {
    suspend operator fun invoke(): Boolean
}

class TurnOffUseCaseImpl @Inject constructor(
    private  val repository: LampRepository
): TurnOffUseCase {
    override suspend operator fun invoke(): Boolean = repository.postTurnOff()
}