package com.payrollapp.presentation.navigation

sealed class Screen(
    val route: String
) {

    data object PayrollList :
        Screen("payroll_list")

    data object CreatePayroll :
        Screen("create_payroll")

    data object PayrollDetail :
        Screen("payroll_detail/{payrollId}") {

        fun createRoute(
            payrollId: Long
        ) = "payroll_detail/$payrollId"
    }
}