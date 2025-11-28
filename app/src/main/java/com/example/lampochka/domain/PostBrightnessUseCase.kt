package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import jakarta.inject.Inject

interface PostBrightnessUseCase {
    suspend operator fun invoke(level: Int): Boolean
}

class PostBrightnessUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): PostBrightnessUseCase{
    override suspend fun invoke(level: Int): Boolean = repository.postBrightness(level)
}