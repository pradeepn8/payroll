package com.payrollapp.data.mapper

import com.payrollapp.data.local.relation.PayrollWithEmployees
import com.payrollapp.domain.model.Employee
import com.payrollapp.domain.model.Payroll

fun PayrollWithEmployees.toDomain(): Payroll {

    return Payroll(
        id = payroll.id,
        createdDate = payroll.createdDate,
        employees = employees.map { employee ->

            Employee(
                id = employee.id,
                name = employee.name,
                wages = employee.wages,
                exempt = employee.exempt
            )
        }
    )
}