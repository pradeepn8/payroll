package com.payrollapp.domain.repository

import com.payrollapp.domain.model.Payroll
import kotlinx.coroutines.flow.Flow

interface PayrollRepository {

    suspend fun getPayrolls(): List<Payroll>

    fun observePayrolls(): Flow<List<Payroll>>

    suspend fun getPayrollById(id: Long): Payroll?

    suspend fun createPayroll(payroll: Payroll)
}