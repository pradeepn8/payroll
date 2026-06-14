package com.payrollapp.data.mapper

import com.payrollapp.data.local.entity.EmployeeEntity
import com.payrollapp.domain.model.Employee

fun EmployeeEntity.toDomain(): Employee {
    return Employee(
        id = id,
        name = name,
        wages = wages,
        exempt = exempt
    )
}

fun Employee.toEntity(payrollId: Long): EmployeeEntity {
    return EmployeeEntity(
        id = id,
        payrollId = payrollId,
        name = name,
        wages = wages,
        exempt = exempt
    )
}