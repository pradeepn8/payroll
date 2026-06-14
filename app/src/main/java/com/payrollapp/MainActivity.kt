package com.payrollapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.payrollapp.presentation.factory.PayrollViewModelFactory
import com.payrollapp.presentation.navigation.PayrollNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val app =
            application as PayrollApplication

        val container =
            app.container

        val factory =
            PayrollViewModelFactory(

                observePayrollsUseCase =
                    container.observePayrollsUseCase,

                getPayrollDetailUseCase =
                    container.getPayrollDetailUseCase,

                createPayrollUseCase =
                    container.createPayrollUseCase
            )
        setContent {
            PayrollNavGraph(
                factory = factory
            )
        }
    }
}




