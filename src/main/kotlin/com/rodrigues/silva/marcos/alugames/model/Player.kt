package com.rodrigues.silva.marcos.alugames.model

import kotlin.random.Random

data class Player(
    var name: String,
    var email: String
) {
    var dataNascimento: String? = null
    var username: String? = null
        set(value) {
            field = value
            if(id.isNullOrBlank()) {
                createId()
            }
        }
    var id: String? = null
        private set

    constructor(name: String, email: String, dataNascimento: String, username: String):
            this(name, email) {
                this.dataNascimento = dataNascimento
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
        return "Player(name='$name', email='$email', dataNascimento=$dataNascimento, username=$username, id=$id)"
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


}