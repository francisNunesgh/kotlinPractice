package com.example.pratica.ui.viewmodel

import com.example.pratica.model.Advice

sealed class AdviceViewModelStateResult {
    data class Success(val advice: Advice): AdviceViewModelStateResult()
    object ErrorUnknown: AdviceViewModelStateResult()
}