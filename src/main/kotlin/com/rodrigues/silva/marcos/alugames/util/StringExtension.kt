package com.rodrigues.silva.marcos.alugames.util

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.yearTransform(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var year = 0
    val birthday = LocalDate.parse(this, formatter)
    val now = LocalDate.now()

    year = Period.between(birthday, now).years

    return year
}