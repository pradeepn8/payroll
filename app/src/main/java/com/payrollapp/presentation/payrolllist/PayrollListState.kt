package com.payrollapp.presentation.payrolllist

import com.payrollapp.domain.model.Payroll

data class PayrollListState(
    val payrolls: List<Payroll> = emptyList()
)