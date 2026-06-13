package com.payrollapp.data.remote

import com.payrollapp.domain.model.Payroll

interface PayrollApi {

    suspend fun fetchPayrolls(): List<Payroll>

    suspend fun createPayroll(payroll: Payroll)
}