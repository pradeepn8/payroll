package com.payrollapp.presentation.payrolldetail

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.payrollapp.domain.usecase.GetPayrollDetailUseCase
import kotlinx.coroutines.launch

class PayrollDetailViewModel(
    private val getPayrollDetailUseCase: GetPayrollDetailUseCase
) : ViewModel() {

    var state by mutableStateOf(
        PayrollDetailState()
    )
        private set

    fun loadPayroll(
        payrollId: Long
    ) {

        viewModelScope.launch {

            state = state.copy(
                payroll = getPayrollDetailUseCase(
                    payrollId
                )
            )
        }
    }
}