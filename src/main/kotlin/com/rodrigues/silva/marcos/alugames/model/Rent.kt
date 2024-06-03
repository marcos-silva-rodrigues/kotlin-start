package com.rodrigues.silva.marcos.alugames.model

import java.time.LocalDate
import java.time.Period

data class Rent(
    val player: Player,
    val game: Game,
    val period: RentPeriod
) {

    val rentValue = game.price * period.betweenInDays()

    override fun toString(): String {
        return "Rent the ${game.title} for ${player.name} with price ${rentValue}"
    }
}