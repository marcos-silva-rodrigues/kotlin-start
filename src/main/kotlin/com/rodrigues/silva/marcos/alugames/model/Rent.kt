package com.rodrigues.silva.marcos.alugames.model

data class Rent(
    val player: Player,
    val game: Game,
    val period: RentPeriod
) {

    val rentValue = player.plan.getValue(this)

    override fun toString(): String {
        return "Rent the ${game.title} for ${player.name} with price ${rentValue}"
    }
}