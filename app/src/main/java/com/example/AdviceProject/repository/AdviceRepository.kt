package com.example.pratica.repository

interface AdviceRepository {
    suspend fun getAdvice(): AdviceRepositoryResult
}