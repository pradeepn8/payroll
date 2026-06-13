package com.payrollapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.payrollapp.domain.usecase.CreatePayrollUseCase
import com.payrollapp.domain.usecase.GetPayrollDetailUseCase
import com.payrollapp.domain.usecase.GetPayrollsUseCase
import com.payrollapp.domain.usecase.ObservePayrollsUseCase
import com.payrollapp.presentation.createpayroll.CreatePayrollViewModel
import com.payrollapp.presentation.payrolldetail.PayrollDetailViewModel
import com.payrollapp.presentation.payrolllist.PayrollListViewModel

class PayrollViewModelFactory(
    private val observePayrollsUseCase: ObservePayrollsUseCase,
    private val getPayrollDetailUseCase: GetPayrollDetailUseCase,
    private val createPayrollUseCase: CreatePayrollUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return when {

            modelClass.isAssignableFrom(
                PayrollListViewModel::class.java
            ) -> {

                PayrollListViewModel(
//                    getPayrollsUseCase
                    observePayrollsUseCase
                ) as T
            }

            modelClass.isAssignableFrom(
                CreatePayrollViewModel::class.java
            ) -> {

                CreatePayrollViewModel(
                    createPayrollUseCase
                ) as T
            }

            modelClass.isAssignableFrom(
                PayrollDetailViewModel::class.java
            ) -> {

                PayrollDetailViewModel(
                    getPayrollDetailUseCase
                ) as T
            }

            else ->
                throw IllegalArgumentException(
                    "Unknown ViewModel"
                )
        }
    }
}