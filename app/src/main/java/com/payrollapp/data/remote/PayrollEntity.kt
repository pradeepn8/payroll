package com.payrollapp.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PayrollEntity(

    @PrimaryKey
    val id: Long,

    val createdDate: String
)