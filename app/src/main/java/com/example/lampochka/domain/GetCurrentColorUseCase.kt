package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import com.example.lampochka.data.models.GetColorsDto
import jakarta.inject.Inject

interface GetCurrentColorUseCase {
    suspend operator fun invoke(): GetColorsDto
}

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetCurrentColorUseCase{
    override suspend fun invoke(): GetColorsDto = repository.getCurrentColor()
}