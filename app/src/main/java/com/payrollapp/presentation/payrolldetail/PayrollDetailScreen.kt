package com.payrollapp.presentation.payrolldetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.payrollapp.domain.model.Payroll

@Composable
fun PayrollDetailScreen(
    payroll: Payroll
) {

    Column(
        modifier = Modifier.padding(
            top = 50.dp,
            bottom = 16.dp,
            start = 16.dp,
            end = 16.dp
        )
    ) {

        payroll.employees.forEach {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Text(it.name)

                    Text("Total : ${it.wages}")

                    Text("Taxes : ${it.taxes}")

                    Text("Net : ${it.net}")
                }
            }
        }

        HorizontalDivider()

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Total : ${payroll.totalAmount}"
        )

        if (payroll.totalTaxes > 0) {

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "Total Taxes : ${payroll.totalTaxes}"
            )
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Total Net : ${payroll.totalNet}"
        )
    }
}