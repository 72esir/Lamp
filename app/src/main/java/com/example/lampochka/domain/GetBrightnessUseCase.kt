package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import com.example.lampochka.data.models.GetBrightnessLevelDto
import jakarta.inject.Inject

interface GetBrightnessUseCase {
    suspend operator fun invoke(): GetBrightnessLevelDto
}

class GetBrightnessUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetBrightnessUseCase {
    override suspend operator fun invoke(): GetBrightnessLevelDto = repository.getBrightness()
}