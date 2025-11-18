package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import com.example.lampochka.data.models.GetColorsDto
import jakarta.inject.Inject

interface GetColorsUseCase {
    suspend operator fun invoke(): Array<GetColorsDto>
}

class GetColorsUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetColorsUseCase{
    override suspend fun invoke(): Array<GetColorsDto> = repository.getColors()

}