package com.payrollapp.domain.model

data class Payroll(
    val id: Long,
    val createdDate: String,
    val employees: List<Employee>
) {
    val totalAmount: Double
        get() = employees.sumOf { it.wages }

    val totalTaxes: Double
        get() = employees.sumOf { it.taxes }

    val totalNet: Double
        get() = employees.sumOf { it.net }
}