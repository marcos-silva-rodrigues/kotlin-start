package com.rodrigues.silva.marcos.alugames.model

class Game(
    val title: String,
    val thumb: String
) {
    var description: String?  = ""
    override fun toString(): String {
        return "Game(title='$title', thumb='$thumb', description='$description')"
    }


}