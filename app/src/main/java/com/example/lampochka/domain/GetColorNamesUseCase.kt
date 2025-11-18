package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import jakarta.inject.Inject


interface GetColorNamesUseCase {
    suspend operator fun invoke(): Array<String>
}

class GetColorNamesUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetColorNamesUseCase{
    override suspend fun invoke(): Array<String> = repository.getColorNames()
}