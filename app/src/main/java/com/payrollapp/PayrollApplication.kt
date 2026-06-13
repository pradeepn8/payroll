package com.payrollapp

import android.app.Application
import com.payrollapp.di.AppContainer

class PayrollApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = AppContainer(this)
    }
}