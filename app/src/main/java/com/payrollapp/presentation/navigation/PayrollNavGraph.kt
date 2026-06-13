package com.payrollapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.payrollapp.presentation.PayrollViewModelFactory
import com.payrollapp.presentation.createpayroll.CreatePayrollScreen
import com.payrollapp.presentation.createpayroll.CreatePayrollViewModel
import com.payrollapp.presentation.payrolldetail.PayrollDetailScreen
import com.payrollapp.presentation.payrolldetail.PayrollDetailViewModel
import com.payrollapp.presentation.payrolllist.PayrollListScreen
import com.payrollapp.presentation.payrolllist.PayrollListViewModel

@Composable
fun PayrollNavGraph(
    factory: PayrollViewModelFactory
) {

    val navController =
        rememberNavController()

    NavHost(
        navController = navController,
        startDestination =
            Screen.PayrollList.route
    ) {

        composable(
            Screen.PayrollList.route
        ) {

            val viewModel:
                    PayrollListViewModel =
                viewModel(factory = factory)

            PayrollListScreen(
                state = viewModel.state,

                onCreatePayroll = {

                    navController.navigate(
                        Screen.CreatePayroll.route
                    )
                },

                onPayrollClick = {

                    navController.navigate(
                        Screen.PayrollDetail
                            .createRoute(it)
                    )
                }
            )
        }

        composable(
            Screen.CreatePayroll.route
        ) {

            val viewModel:
                    CreatePayrollViewModel =
                viewModel(factory = factory)

            CreatePayrollScreen(
                viewModel = viewModel,

                onSave = {

                    navController.popBackStack()
                }
            )
        }

        composable(
            route =
                Screen.PayrollDetail.route,

            arguments = listOf(
                navArgument(
                    "payrollId"
                ) {
                    type = NavType.LongType
                }
            )
        ) { backStackEntry ->

            val payrollId =
                backStackEntry
                    .arguments
                    ?.getLong("payrollId")
                    ?: 0L

            val viewModel:
                    PayrollDetailViewModel =
                viewModel(factory = factory)

            LaunchedEffect(
                payrollId
            ) {
                viewModel.loadPayroll(
                    payrollId
                )
            }

            viewModel.state.payroll?.let {

                PayrollDetailScreen(
                    payroll = it
                )
            }
        }
    }
}