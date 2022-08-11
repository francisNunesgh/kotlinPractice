package com.example.pratica.webclient.service

import com.example.pratica.model.SlipResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceService {
    @GET("/advice")
    suspend fun getAdvice(): Response<SlipResponse>
}