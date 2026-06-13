package com.payrollapp.domain.usecase

import com.payrollapp.domain.repository.PayrollRepository

class GetPayrollDetailUseCase(
    private val repository: PayrollRepository
) {

    suspend operator fun invoke(id: Long) =
        repository.getPayrollById(id)

}