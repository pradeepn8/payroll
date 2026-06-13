package com.payrollapp.util

import java.text.NumberFormat
import java.util.Locale

fun Double.toCurrency(): String {

    return NumberFormat
        .getCurrencyInstance(
            Locale.US
        )
        .format(this)
}