package com.payrollapp.data.remote

import com.payrollapp.domain.model.Employee
import com.payrollapp.domain.model.Payroll
import com.payrollapp.domain.repository.PayrollRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PayrollRepositoryImpl(
    private val api: PayrollApi,
    private val dao: PayrollDao
) : PayrollRepository {

    override suspend fun getPayrolls(): List<Payroll> {

        val local = dao.getPayrolls()

        return local.map {

            Payroll(
                id = it.payroll.id,
                createdDate = it.payroll.createdDate,
                employees = it.employees.map { employee ->

                    Employee(
                        id = employee.id,
                        name = employee.name,
                        wages = employee.wages,
                        exempt = employee.exempt
                    )
                }
            )
        }
    }

    override fun observePayrolls(): Flow<List<Payroll>> {

        return dao.observePayrolls().map { payrolls ->

            payrolls.map { payrollWithEmployees ->

                Payroll(
                    id = payrollWithEmployees.payroll.id,
                    createdDate = payrollWithEmployees.payroll.createdDate,
                    employees = payrollWithEmployees.employees.map {

                        Employee(
                            id = it.id,
                            name = it.name,
                            wages = it.wages,
                            exempt = it.exempt
                        )
                    }
                )
            }
        }
    }

    override suspend fun getPayrollById(
        id: Long
    ): Payroll? {

        val payroll = dao.getPayroll(id)
            ?: return null

        return Payroll(
            id = payroll.payroll.id,
            createdDate = payroll.payroll.createdDate,
            employees = payroll.employees.map {

                Employee(
                    id = it.id,
                    name = it.name,
                    wages = it.wages,
                    exempt = it.exempt
                )
            }
        )
    }

    override suspend fun createPayroll(
        payroll: Payroll
    ) {

        api.createPayroll(payroll)

        dao.insertPayroll(
            PayrollEntity(
                id = payroll.id,
                createdDate = payroll.createdDate
            )
        )

        dao.insertEmployees(
            payroll.employees.map {

                EmployeeEntity(
                    payrollId = payroll.id,
                    name = it.name,
                    wages = it.wages,
                    exempt = it.exempt
                )
            }
        )
    }
}