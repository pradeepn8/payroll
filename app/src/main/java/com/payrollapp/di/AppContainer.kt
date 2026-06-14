package com.payrollapp.di

import android.content.Context
import androidx.room.Room
import com.payrollapp.data.local.PayrollDatabase
import com.payrollapp.data.repository.PayrollRepositoryImpl
import com.payrollapp.domain.usecase.CreatePayrollUseCase
import com.payrollapp.domain.usecase.GetPayrollDetailUseCase
import com.payrollapp.domain.repository.PayrollRepository
import com.payrollapp.domain.usecase.ObservePayrollsUseCase

class AppContainer(
    context: Context
) {

    private val database =
        Room.databaseBuilder(
            context,
            PayrollDatabase::class.java,
            "payroll_db"
        ).build()

    private val dao =
        database.payrollDao()

    private val repository:
            PayrollRepository =
        PayrollRepositoryImpl(
            dao
        )

    val observePayrollsUseCase =
        ObservePayrollsUseCase(repository)

    val getPayrollDetailUseCase =
        GetPayrollDetailUseCase(repository)

    val createPayrollUseCase =
        CreatePayrollUseCase(repository)
}