package com.payrollapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.payrollapp.data.local.entity.EmployeeEntity
import com.payrollapp.data.local.dao.PayrollDao
import com.payrollapp.data.local.entity.PayrollEntity

@Database(
    entities = [
        PayrollEntity::class,
        EmployeeEntity::class
    ],
    version = 1
)
abstract class PayrollDatabase : RoomDatabase() {

    abstract fun payrollDao(): PayrollDao
}