package com.payrollapp.data.mapper

import com.payrollapp.data.local.entity.PayrollEntity
import com.payrollapp.domain.model.Payroll

fun Payroll.toEntity(): PayrollEntity {

    return PayrollEntity(
        id = id,
        createdDate = createdDate
    )
}