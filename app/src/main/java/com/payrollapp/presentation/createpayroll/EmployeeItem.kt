package com.payrollapp.presentation.createpayroll

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.payrollapp.domain.model.Employee
import com.payrollapp.util.toCurrency

@Composable
fun EmployeeItem(
    employee: Employee,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {

        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Text(
                text = employee.name
            )

            Text(
                text =
                    "Wages: ${employee.wages.toCurrency()}"
            )

            Text(
                text =
                    if (employee.exempt)
                        "Exempt"
                    else
                        "Taxable"
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            OutlinedButton(
                onClick = onDelete
            ) {

                Text("Remove")
            }
        }
    }
}