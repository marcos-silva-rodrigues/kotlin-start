package com.rodrigues.silva.marcos.alugames.util

import com.rodrigues.silva.marcos.alugames.model.InfoPlayerJson
import com.rodrigues.silva.marcos.alugames.model.Player

fun InfoPlayerJson.createPlayer(): Player {
    return  Player(
        this.nome,
        this.email
    )
}