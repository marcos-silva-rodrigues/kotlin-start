package com.rodrigues.silva.marcos.alugames.principal

import com.rodrigues.silva.marcos.alugames.model.RentPeriod
import com.rodrigues.silva.marcos.alugames.service.ApiConsume
import java.time.LocalDate

fun main() {
    val api = ApiConsume()
    val playerList = api.findPlayers()
    val gameList = api.findGames()

    val playerCaroline = playerList.get(3)
    val residentVillage = gameList.get(10)
    val spider = gameList.get(13)
    val theLastOfUs = gameList.get(2)


    val periodo1 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = RentPeriod(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = RentPeriod(LocalDate.of(2023,8,2), LocalDate.of(2023,8,15))

    playerCaroline.rentGame(residentVillage, periodo1)
    playerCaroline.rentGame(spider, periodo2)
    playerCaroline.rentGame(theLastOfUs, periodo3)
    playerCaroline.rentGame(spider, periodo4)

    println(playerCaroline.gameMonth(7))
}