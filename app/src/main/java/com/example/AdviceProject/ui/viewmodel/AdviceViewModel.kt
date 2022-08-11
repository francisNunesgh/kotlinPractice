package com.example.pratica.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pratica.repository.AdviceRepository
import com.example.pratica.repository.AdviceRepositoryResult
import kotlinx.coroutines.launch

class AdviceViewModel(private val adviceRepository: AdviceRepository) : ViewModel() {

    private val _adviceState = MutableLiveData<AdviceViewModelStateResult>()
    val adviceState: LiveData<AdviceViewModelStateResult>
        get() = _adviceState

    fun updateAdvice() {
        viewModelScope.launch {
            val adviceRepositoryResult = adviceRepository.getAdvice()
            when (adviceRepositoryResult) {
                is AdviceRepositoryResult.ErrorUnknown -> {
                    _adviceState.postValue(AdviceViewModelStateResult.ErrorUnknown)
                }
                is AdviceRepositoryResult.Success -> {
                    _adviceState.postValue(AdviceViewModelStateResult.Success(adviceRepositoryResult.advice))
                }
            }
        }
    }
}
