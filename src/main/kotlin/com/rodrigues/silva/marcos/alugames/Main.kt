package com.rodrigues.silva.marcos.alugames

import com.rodrigues.silva.marcos.alugames.model.Game
import com.rodrigues.silva.marcos.alugames.model.Player
import com.rodrigues.silva.marcos.alugames.service.ApiConsume
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter with game id:")
    val search = scanner.nextLine()

    var myGame: Game? = null

    val result = runCatching {
        val infoGame = ApiConsume()
            .searchByGameId(search)
        myGame= Game(
            infoGame.info.title,
            infoGame.info.thumb)

        println(myGame)
    }

    result.onFailure {
        println(it.message)
    }

    result.onSuccess {
        println("Add custom description? S/N")
        val option = scanner.nextLine()

        if(option.equals("S", true)) {
            println("Enter with description: ")
            myGame?.description = scanner.nextLine()
        } else {
            myGame?.description = myGame?.title
        }
    }

    val player1 = Player("Fulano", "fulano@email.com")

    player1.let {
        it.dataNascimento = "10/11/1995"
        it.username = "KFunc"
    }.also {
        println(player1.id)
    }







}