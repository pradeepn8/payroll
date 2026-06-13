package com.payrollapp.data.remote

import androidx.room.Embedded
import androidx.room.Relation

data class PayrollWithEmployees(

    @Embedded
    val payroll: PayrollEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "payrollId"
    )
    val employees: List<EmployeeEntity>
)