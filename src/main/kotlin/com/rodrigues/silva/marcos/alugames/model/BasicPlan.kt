package com.rodrigues.silva.marcos.alugames.model

class BasicPlan(type: String): Plan(type) {
    override fun getValue(rent: Rent): Double {
        var originalValue = super.getValue(rent)
        if (rent.player.media > 8) {
            originalValue -= originalValue * 0.1
        }

        return originalValue
    }
}
