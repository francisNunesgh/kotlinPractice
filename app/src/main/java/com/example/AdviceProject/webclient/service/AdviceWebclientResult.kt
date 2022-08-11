package com.example.pratica.webclient.service

import com.example.pratica.model.AdviceData

sealed class AdviceWebclientResult{
    data class Success(val adviceData: AdviceData) : AdviceWebclientResult()
    object ErrorUnknown: AdviceWebclientResult()
}


