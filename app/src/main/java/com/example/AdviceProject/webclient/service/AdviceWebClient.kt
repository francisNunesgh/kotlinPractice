package com.example.pratica.webclient.service

import com.example.pratica.model.AdviceData
import java.lang.Exception

class AdviceWebClient(private val adviceService: AdviceService) {

    suspend fun getAdvice(): AdviceWebclientResult {
        try {
            val adviceResponse = adviceService.getAdvice()
            if (adviceResponse.isSuccessful) {
                adviceResponse.body()?.let {
                    val adviceData: AdviceData = it.slip
                    return AdviceWebclientResult.Success(adviceData)
                } ?: return AdviceWebclientResult.ErrorUnknown
            } else {
                return AdviceWebclientResult.ErrorUnknown
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return AdviceWebclientResult.ErrorUnknown
        }
    }
}

