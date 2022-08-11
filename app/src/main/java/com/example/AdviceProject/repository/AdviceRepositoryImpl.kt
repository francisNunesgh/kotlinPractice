package com.example.pratica.repository

import android.util.Log
import com.example.pratica.model.Advice
import com.example.pratica.webclient.service.AdviceWebClient
import com.example.pratica.webclient.service.AdviceWebclientResult

class AdviceRepositoryImpl(private val adviceWebClient: AdviceWebClient): AdviceRepository {

    override suspend fun getAdvice(): AdviceRepositoryResult {
        val adviceWebclientResult = adviceWebClient.getAdvice()
        when(adviceWebclientResult) {
            is AdviceWebclientResult.ErrorUnknown -> {
                return AdviceRepositoryResult.ErrorUnknown
            }
            is AdviceWebclientResult.Success -> {
                adviceWebclientResult.adviceData.let {
                    val advice: Advice = it.convertToAdvice()
                    Log.i("AdviceRepository", "$advice")
                   return AdviceRepositoryResult.Success(advice)
                }
            }
        }
    }
}

