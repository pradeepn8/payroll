package com.payrollapp.domain.usecase

import com.payrollapp.domain.repository.PayrollRepository

class ObservePayrollsUseCase(
    private val repository: PayrollRepository
) {

    operator fun invoke() =
        repository.observePayrolls()
}