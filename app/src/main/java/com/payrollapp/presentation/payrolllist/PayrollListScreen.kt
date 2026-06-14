package com.payrollapp.presentation.payrolllist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PayrollListScreen(
    state: PayrollListState,
    onCreatePayroll: () -> Unit,
    onPayrollClick: (Long) -> Unit
) {

    Scaffold(

        bottomBar = {
            Button(
                onClick = onCreatePayroll,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp)
            ) {
                Text("Create Payroll")
            }
        }

    ) { padding ->

        if (state.payrolls.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "No Payrolls Created",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

        } else {
            LazyColumn(
                modifier = Modifier.padding(padding)
            ) {

                items(state.payrolls) { payroll ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                onPayrollClick(payroll.id)
                            }
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(payroll.createdDate)

                            Text(
                                "Employees: ${payroll.employees.size}"
                            )

                            Text(
                                "Amount: ${payroll.totalAmount}"
                            )
                        }
                    }
                }
            }
        }
    }
}