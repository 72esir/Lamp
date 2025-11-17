package com.example.lampochka.data.domain

import com.example.lampochka.data.BulbRepository
import jakarta.inject.Inject

interface TurnOffUseCase {
    suspend operator fun invoke()
}

class TurnOffUseCaseImpl @Inject constructor(
    private  val repository: BulbRepository
): TurnOffUseCase {
    override suspend operator fun invoke() =
        repository.postTurnOff()
}