package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import jakarta.inject.Inject

interface GetCurrentBrightnessUseCase
{
    suspend operator fun invoke(): Int
}

class GetCurrentBrightnessUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetCurrentBrightnessUseCase {
    override suspend fun invoke(): Int = repository.getCurrentBrightness()
}