package com.example.pratica.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.pratica.R
import com.example.pratica.model.AdviceData
import com.example.pratica.repository.AdviceRepository
import com.example.pratica.repository.AdviceRepositoryResult
import com.example.pratica.ui.viewmodel.AdviceViewModel
import com.example.pratica.ui.viewmodel.AdviceViewModelStateResult
import com.example.pratica.webclient.service.AdviceWebClient
import com.example.pratica.webclient.service.AdviceWebclientResult
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.lang.Exception

class MainActivity : AppCompatActivity() {
//    private val adviceViewModel: AdviceViewModel by inject()
//    private val adviceRepository: AdviceRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //observeAdvice()
        //adviceViewModel.updateAdvice()
//        lifecycleScope.launch{
//            val result = adviceRepository.getAdvice()
//            when(result) {
//                is AdviceRepositoryResult.ErrorUnknown -> {}
//                is AdviceRepositoryResult.Success -> {}
//            }
//        }
//    }

//    fun observeAdvice() {
//        adviceViewModel.adviceState.observe(this) {
//            when(it) {
//                is AdviceViewModelStateResult.ErrorUnknown -> {
//                    Log.d("Advice", "ErroDesconhecido")
//                }
//                is AdviceViewModelStateResult.Success -> {
//                    val advice = it.advice
//                    Log.d("Advice", "$advice")
//                }
//            }
//        }
    }

}