package com.payrollapp.presentation.createpayroll

import com.payrollapp.domain.model.Employee

data class CreatePayrollState(

    val employeeName: String = "",

    val wages: String = "",

    val exempt: Boolean = false,

    val employees: List<Employee> = emptyList(),

    val errorMessage: String? = null
)