package com.example.lampochka.domain

import com.example.lampochka.data.LampRepository
import jakarta.inject.Inject


interface PostColorUseCase {
    suspend operator fun invoke(color: String): Boolean
}

class PostColorUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): PostColorUseCase{
    override suspend fun invoke(color: String): Boolean = repository.setColor(color)

}