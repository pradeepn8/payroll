package com.payrollapp.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.payrollapp.data.local.entity.EmployeeEntity
import com.payrollapp.data.local.entity.PayrollEntity

data class PayrollWithEmployees(

    @Embedded
    val payroll: PayrollEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "payrollId"
    )
    val employees: List<EmployeeEntity>
)