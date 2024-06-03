package com.rodrigues.silva.marcos.alugames.model

import java.time.LocalDate
import java.time.Period

data class RentPeriod(
    val initialDate: LocalDate,
    val finalDate: LocalDate
) {

    fun betweenInDays(): Int {
        return Period.between(initialDate, finalDate).days
    }
}