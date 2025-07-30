package com.example.fit_iq.domain.model



enum class TimeRange(
    val label: String
) {
    LAST7DAYS(label = "Last 7 days"),
    LAST30DAYS(label = "Last 30 days"),
    ALL_TIME(label = "All time")
}