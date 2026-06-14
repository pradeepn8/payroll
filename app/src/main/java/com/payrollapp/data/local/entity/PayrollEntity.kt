package com.payrollapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PayrollEntity(

    @PrimaryKey
    val id: Long,

    val createdDate: String
)