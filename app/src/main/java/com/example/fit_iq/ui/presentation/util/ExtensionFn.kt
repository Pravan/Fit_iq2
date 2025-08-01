package com.example.fit_iq.ui.presentation.util

import kotlin.math.pow
import kotlin.math.roundToInt

fun Float.roundtoDecimal(decimalPlaces: Int = 1 ): Float {
    val multiplier = 10.0.pow(decimalPlaces)
    return (this * multiplier).roundToInt() / multiplier.toFloat()
}

