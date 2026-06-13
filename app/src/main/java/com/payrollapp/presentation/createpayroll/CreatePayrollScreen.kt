package com.payrollapp.presentation.createpayroll

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePayrollScreen(
    viewModel: CreatePayrollViewModel,
    onSave: () -> Unit
) {

    val state = viewModel.state

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("Create Payroll")
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            OutlinedTextField(

                value =
                    state.employeeName,

                onValueChange =
                    viewModel::onNameChange,

                label = {
                    Text("Employee Name")
                },

                modifier =
                    Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            OutlinedTextField(

                value = state.wages,

                onValueChange =
                    viewModel::onWagesChange,

                label = {
                    Text("Wages")
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),

                modifier =
                    Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Checkbox(

                    checked =
                        state.exempt,

                    onCheckedChange =
                        viewModel::onExemptChange
                )

                Text(
                    text = "Tax Exempt"
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                modifier =
                    Modifier.fillMaxWidth(),

                onClick = {

                    viewModel.addEmployee()
                }
            ) {

                Text(
                    "Add Employee"
                )
            }

            state.errorMessage?.let {

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                Text(
                    text = it,
                    color =
                        MaterialTheme.colorScheme.error
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text =
                    "Employees (${state.employees.size})",

                style =
                    MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(state.employees) {

                    EmployeeItem(

                        employee = it,

                        onDelete = {

                            viewModel.removeEmployee(
                                it
                            )
                        }
                    )
                }
            }

            Button(

                modifier =
                    Modifier.fillMaxWidth(),

                enabled =
                    state.employees.isNotEmpty(),

                onClick = {

                    viewModel.createPayroll {

                        onSave()
                    }
                }
            ) {

                Text(
                    "Save Payroll"
                )
            }
        }
    }
}