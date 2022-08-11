package com.example.pratica.repository

import com.example.pratica.model.Advice

sealed class AdviceRepositoryResult {
    data class Success(val advice: Advice) : AdviceRepositoryResult()
    object ErrorUnknown: AdviceRepositoryResult()
}