package com.payrollapp.data.repository

import com.payrollapp.data.local.dao.PayrollDao
import com.payrollapp.data.mapper.toDomain
import com.payrollapp.data.mapper.toEntity
import com.payrollapp.data.remote.PayrollApi
import com.payrollapp.domain.model.Payroll
import com.payrollapp.domain.repository.PayrollRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PayrollRepositoryImpl(
    private val dao: PayrollDao
) : PayrollRepository {


    override suspend fun getPayrolls(): List<Payroll> {

        return dao.getPayrolls()
            .map { it.toDomain() }
    }

    override fun observePayrolls(): Flow<List<Payroll>> {

        return dao.observePayrolls()
            .map { payrolls ->
                payrolls.map { it.toDomain() }
            }
    }

    override suspend fun getPayrollById(
        id: Long
    ): Payroll? {

        return dao.getPayroll(id)
            ?.toDomain()
    }

    override suspend fun createPayroll(
        payroll: Payroll
    ) {

        val payrollId = dao.insertPayroll(
            payroll.toEntity()
        )

        dao.insertEmployees(
            payroll.employees.map {
                it.toEntity(payrollId)
            }
        )
    }
}