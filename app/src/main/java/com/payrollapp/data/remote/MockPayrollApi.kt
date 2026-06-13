package com.payrollapp.data.remote

import com.payrollapp.domain.model.Payroll
import kotlinx.coroutines.delay

class MockPayrollApi : PayrollApi {

    private val payrolls = mutableListOf<Payroll>()

    override suspend fun fetchPayrolls(): List<Payroll> {
        delay(500)
        return payrolls
    }

    override suspend fun createPayroll(payroll: Payroll) {
        delay(500)
        payrolls.add(payroll)
    }
}