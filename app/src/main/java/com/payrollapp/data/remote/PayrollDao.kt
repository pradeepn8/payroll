package com.payrollapp.data.remote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface PayrollDao {

    @Transaction
    @Query("SELECT * FROM PayrollEntity")
    suspend fun getPayrolls(): List<PayrollWithEmployees>

    @Transaction
    @Query("SELECT * FROM PayrollEntity")
    fun observePayrolls(): Flow<List<PayrollWithEmployees>>

    @Transaction
    @Query("SELECT * FROM PayrollEntity WHERE id=:id")
    suspend fun getPayroll(id: Long): PayrollWithEmployees?

    @Insert
    suspend fun insertPayroll(payroll: PayrollEntity)

    @Insert
    suspend fun insertEmployees(
        employees: List<EmployeeEntity>
    )
}