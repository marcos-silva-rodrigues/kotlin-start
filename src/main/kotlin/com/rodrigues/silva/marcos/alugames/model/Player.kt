package com.rodrigues.silva.marcos.alugames.model

import java.util.Scanner
import kotlin.random.Random

data class Player(
    var name: String,
    var email: String
): Recommended {
    var birthday: String? = null
    var username: String? = null
        set(value) {
            field = value
            if(id.isNullOrBlank()) {
                createId()
            }
        }
    var id: String? = null
        private set

    var plan: Plan = BasicPlan("BRONZE")
    val gameList = mutableListOf<Game?>()
    val rentGames = mutableListOf<Rent>()
    val recommendedGames = mutableListOf<Game>()
    private val ratingList = mutableListOf<Int>()

    override val media: Double
        get() = ratingList.average()

    override fun recommended(rating: Int) {
        ratingList.add(rating)
    }

    fun recommendedGame(game: Game, nota: Int) {
        game.recommended(nota)
        recommendedGames.add(game)
    }
    constructor(name: String, email: String, birthday: String, username: String):
            this(name, email) {
                this.birthday = birthday
                this.username = username
                createId()
            }

    init {
        if(name.isNullOrBlank()){
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Player(name='$name', email='$email', birthday=$birthday, username=$username, id=$id, media=$media)"
    }

    private fun createId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$username#$tag"
    }

    private fun validateEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)){
            return email
        } else{
            throw IllegalArgumentException("Email inválido")
        }
    }

    fun rentGame(game: Game, period: RentPeriod): Rent {
        val rent = Rent(this, game, period)
        rentGames.add(rent)

        return rent
    }

    fun gameMonth(month: Int): List<Game> {
        return rentGames
            .filter { rent ->  rent.period.initialDate.monthValue == month}
            .map { rent ->  rent.game}
    }


    companion object {
        fun createPlayer(reading: Scanner): Player {
            println("Welcome AluGames! Enter with you name:")
            val name = reading.nextLine()
            println("you e-mail:")
            val email = reading.nextLine()
            println("Should completed sign in with you birthday and username? (S/N)")
            val option = reading.nextLine()

            if (option.equals("s", true)) {
                println("Enter with you birthday (DD/MM/AAAA):")
                val birthday = reading.nextLine()
                println("Enter with you username")
                val username = reading.nextLine()

                return Player(name, email, birthday, username)
            } else {
                return Player(name, email)
            }
        }
    }


}