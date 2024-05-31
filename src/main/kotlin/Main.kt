package com.rodrigues.silva.marcos

import Game
import InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter with game id:")
    val search = scanner.nextLine()

    val uri = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .build()

    val response = client.send(request, BodyHandlers.ofString())
    val json = response.body()

    val gson = Gson()

    var myGame: Game? = null
    val result = runCatching {
        val infoGame = gson.fromJson(json,
            InfoGame::class.java)

        myGame= Game(
            infoGame.info.title,
            infoGame.info.thumb)

        println(myGame)
    }

    result.onFailure {
        println("invalid game id")
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







}