package com.rodrigues.silva.marcos.alugames.model

class SubscribePlan(
    type: String,
    val monthly: Double,
    val games: Int,
    val discountPercentage: Double) : Plan(type)
{
    override fun getValue(rent: Rent): Double {
        val totalGameOfMonth = rent.player.gameMonth(
            rent.period.initialDate.monthValue
        ).size + 1

        return if (totalGameOfMonth <= games) {
            0.0
        } else {
            var originalValue = super.getValue(rent)

            if (rent.player.media > 8) {
                originalValue -= originalValue * discountPercentage
            }

            originalValue
        }
    }
    }


