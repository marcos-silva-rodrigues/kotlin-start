package com.rodrigues.silva.marcos.alugames.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rodrigues.silva.marcos.alugames.model.*
import com.rodrigues.silva.marcos.alugames.util.createGame
import com.rodrigues.silva.marcos.alugames.util.createPlayer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsume {

    fun searchByGameId(id: String): InfoGame {
        val uri = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consumeData(uri)

        val gson = Gson()

        var infoGame: InfoGame? = null
        val result = runCatching {
            gson.fromJson(json,
                InfoGame::class.java)
        }

        result.onSuccess {
            infoGame = it
        }

        result.onFailure {
            throw RuntimeException("Game id not found");
        }

        return infoGame!!;
    }

    fun findGames(): List<Game> {
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumeData(uri)

        val gson = Gson()
        val gameType = object : TypeToken<List<InfoGameJson>>() {}.type
        val gameInfoList:List<InfoGameJson> = gson.fromJson(json, gameType)

        val gameList = gameInfoList.map { infoGamerJson -> infoGamerJson.createGame() }

        return gameList
    }

    fun findPlayers(): List<Player> {
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consumeData(uri)

        val gson = Gson()

        val playerType = object : TypeToken<List<InfoPlayerJson>>() {}.type
        var playerInfoList: List<InfoPlayerJson> = gson.fromJson(json, playerType)

        val playerList = playerInfoList.map { playerJson ->
            playerJson.createPlayer()
        }

        return playerList;
    }

    private fun consumeData(uri: String): String? {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()
        return json
    }
}