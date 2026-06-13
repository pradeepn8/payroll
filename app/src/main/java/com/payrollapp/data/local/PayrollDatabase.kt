package com.payrollapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.payrollapp.data.remote.EmployeeEntity
import com.payrollapp.data.remote.PayrollDao
import com.payrollapp.data.remote.PayrollEntity

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