package com.rodrigues.silva.marcos.alugames.model

open class Plan(val type: String) {

    open fun getValue(rent: Rent): Double {
        return rent.game.price * rent.period.betweenInDays()
    }
}