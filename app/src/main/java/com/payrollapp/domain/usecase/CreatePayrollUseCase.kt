package com.payrollapp.domain.usecase

import com.payrollapp.domain.model.Payroll
import com.payrollapp.domain.repository.PayrollRepository

class CreatePayrollUseCase(
    private val repository: PayrollRepository
) {

    suspend operator fun invoke(
        payroll: Payroll
    ) {
        repository.createPayroll(payroll)
    }
}