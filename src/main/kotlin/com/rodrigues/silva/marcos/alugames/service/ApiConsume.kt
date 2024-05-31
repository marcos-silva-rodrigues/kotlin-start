package com.rodrigues.silva.marcos.alugames.service

import com.google.gson.Gson
import com.rodrigues.silva.marcos.alugames.model.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsume {

    fun searchByGameId(id: String): InfoGame {
        val uri = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()

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
}