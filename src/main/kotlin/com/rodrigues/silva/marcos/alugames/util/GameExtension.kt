package com.rodrigues.silva.marcos.alugames.util

import com.rodrigues.silva.marcos.alugames.model.Game
import com.rodrigues.silva.marcos.alugames.model.InfoGameJson

fun InfoGameJson.createGame(): Game {
    return Game(
        this.title,
        this.thumb,
        this.price,
        this.description
    )
}