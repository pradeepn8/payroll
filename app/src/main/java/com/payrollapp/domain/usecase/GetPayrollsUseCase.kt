package com.payrollapp.domain.usecase

import com.payrollapp.domain.repository.PayrollRepository

class GetPayrollsUseCase(
    private val repository: PayrollRepository
) {

    suspend operator fun invoke() =
        repository.getPayrolls()
}