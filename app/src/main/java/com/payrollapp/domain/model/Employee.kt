package com.payrollapp.domain.model

data class Employee(
    val id: Long = 0,
    val name: String,
    val wages: Double,
    val exempt: Boolean
) {
    val taxes: Double
        get() = if (!exempt && wages > 1000)
            wages * 0.05
        else
            0.0

    val net: Double
        get() = wages - taxes
}