package com.rodrigues.silva.marcos.alugames

import com.rodrigues.silva.marcos.alugames.model.Game
import com.rodrigues.silva.marcos.alugames.model.Player
import com.rodrigues.silva.marcos.alugames.service.ApiConsume
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val player = Player.createPlayer(scanner);
    println("Account create with successfully!")

    do {
        println("Enter with game id:")
        val search = scanner.nextLine()

        var myGame: Game? = null
        val result = runCatching {
            val infoGame = ApiConsume()
                .searchByGameId(search)

            myGame = Game(
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

            player.gameList.add(myGame)
        }

        println("Game added sorted:")
        player.gameList.sortBy {
            it?.title
        }

        player.gameList.forEach {
            println("Title: " + it?.title)
        }

        println("I'd like to find another game? S/N")
        val answer = scanner.nextLine()
    } while (answer.equals("s", true))

    println("Search ends successfully")
}