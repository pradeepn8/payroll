package com.payrollapp.presentation.createpayroll

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.payrollapp.domain.model.Employee
import com.payrollapp.domain.model.Payroll
import com.payrollapp.domain.usecase.CreatePayrollUseCase
import kotlinx.coroutines.launch
import java.time.LocalDate

class CreatePayrollViewModel(
    private val createPayrollUseCase: CreatePayrollUseCase
) : ViewModel() {

    var state by mutableStateOf(
        CreatePayrollState()
    )
        private set

    fun onNameChange(name: String) {
        state = state.copy(
            employeeName = name
        )
    }

    fun onWagesChange(wages: String) {
        state = state.copy(
            wages = wages
        )
    }

    fun onExemptChange(exempt: Boolean) {
        state = state.copy(
            exempt = exempt
        )
    }

    fun addEmployee() {

        val name = state.employeeName.trim()

        val wages =
            state.wages.toDoubleOrNull()

        when {

            name.isEmpty() -> {

                state = state.copy(
                    errorMessage =
                        "Employee name required"
                )
            }

            wages == null -> {

                state = state.copy(
                    errorMessage =
                        "Enter valid wages"
                )
            }

            wages <= 0 -> {

                state = state.copy(
                    errorMessage =
                        "Wages must be greater than 0"
                )
            }

            else -> {

                val employee =
                    Employee(
                        name = name,
                        wages = wages,
                        exempt = state.exempt
                    )

                state = state.copy(

                    employees =
                        state.employees + employee,

                    employeeName = "",

                    wages = "",

                    exempt = false,

                    errorMessage = null
                )
            }
        }
    }

    fun removeEmployee(
        employee: Employee
    ) {

        state = state.copy(
            employees =
                state.employees - employee
        )
    }

    fun createPayroll(
        onSuccess: () -> Unit
    ) {

        if (state.employees.isEmpty()) {

            state = state.copy(
                errorMessage =
                    "Add at least one employee"
            )
            return
        }

        viewModelScope.launch {

            createPayrollUseCase(

                Payroll(
                    id = System.currentTimeMillis(),

                    createdDate =
                        LocalDate.now().toString(),

                    employees =
                        state.employees
                )
            )

            onSuccess()
        }
    }
}