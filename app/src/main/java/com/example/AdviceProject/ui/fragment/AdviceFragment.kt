package com.example.pratica.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pratica.R
import com.example.pratica.databinding.AdviceFragmentBinding
import com.example.pratica.ui.viewmodel.AdviceViewModel
import com.example.pratica.ui.viewmodel.AdviceViewModelStateResult
import org.koin.android.ext.android.inject

class AdviceFragment : Fragment(){
    private val navController by lazy {
        findNavController()
    }

    private lateinit var binding: AdviceFragmentBinding
    private val adviceViewModel: AdviceViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = AdviceFragmentBinding
            .inflate(
            inflater,
            container,
            false
        )
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAdviceState()
        updateAdviceState()
        setupAskForAdviceButton()
    }

    private fun observeAdviceState() {
        adviceViewModel.adviceState.observe(viewLifecycleOwner) {
            when(it) {
                is AdviceViewModelStateResult.ErrorUnknown -> {
                    binding.TextViewId.text = "Sorry an error happened"
                }
                is AdviceViewModelStateResult.Success -> {
                    val adviceView = it.advice
                    binding.TextViewId.text = adviceView.advice
                }
            }
        }
    }

    private fun updateAdviceState() {
        adviceViewModel.updateAdvice()
    }

    private fun setupAskForAdviceButton() {
        binding.buttonAskForAdvice.setOnClickListener{
            adviceViewModel.updateAdvice()
        }
    }
}