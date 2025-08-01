package com.example.fit_iq.domain.model

import java.time.LocalDate
import java.time.ZoneId

data class BodyPartValue(
    val value: Float,
    val date:LocalDate,
    val bodyPartId: String? = null,
    val bodyPartValueId: String? = null,
)
