package com.payrollapp.presentation.payrolllist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.payrollapp.domain.usecase.ObservePayrollsUseCase
import kotlinx.coroutines.launch

class PayrollListViewModel(
    private val observePayrollsUseCase: ObservePayrollsUseCase
) : ViewModel() {

    var state by mutableStateOf(
        PayrollListState()
    )

    init {

        viewModelScope.launch {

            observePayrollsUseCase()
                .collect { payrolls ->

                    state = state.copy(
                        payrolls = payrolls
                    )
                }
        }
    }
}