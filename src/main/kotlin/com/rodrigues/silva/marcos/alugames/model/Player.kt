package com.rodrigues.silva.marcos.alugames.model

data class Player(
    var name: String,
    var email: String
) {
    var dataNascimento: String? = null
    var username: String? = null
    val id: String? = null

    constructor(name: String, email: String, dataNascimento: String, username: String):
            this(name, email) {
                this.dataNascimento = dataNascimento
                this.username = username
            }

    override fun toString(): String {
        return "Player(name='$name', email='$email', dataNascimento=$dataNascimento, username=$username, id=$id)"
    }


}