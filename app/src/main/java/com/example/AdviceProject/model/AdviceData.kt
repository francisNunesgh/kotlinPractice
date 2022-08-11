package com.example.pratica.model

import com.squareup.moshi.Json

data class AdviceData(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "advice") val advice: String
) {
    fun convertToAdvice(): Advice {
        val advice: Advice = Advice(this.advice)
        return advice
    }
}