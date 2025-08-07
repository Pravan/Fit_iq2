package com.example.fit_iq.ui.presentation.util

import com.example.fit_iq.domain.model.BodyPartValue
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.pow
import kotlin.math.roundToInt

fun Float.roundtoDecimal(decimalPlaces: Int = 1 ): Float {
    val multiplier = 10.0.pow(decimalPlaces)
    return (this * multiplier).roundToInt() / multiplier.toFloat()
}

fun LocalDate?.changeLocalDateToGraphDate(
    defaultValue: LocalDate=LocalDate.now()
): String{
    return try {
        this?.format(DateTimeFormatter.ofPattern("MMM dd"))
            ?: defaultValue.format(DateTimeFormatter.ofPattern("MMM dd"))

    } catch (e: Exception) {
        defaultValue.format(DateTimeFormatter.ofPattern("MMM dd"))
    }
}

