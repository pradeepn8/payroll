package com.payrollapp.presentation

data class EmployeeUiState(
    val name: String = "",
    val wages: String = "",
    val exempt: Boolean = false
)