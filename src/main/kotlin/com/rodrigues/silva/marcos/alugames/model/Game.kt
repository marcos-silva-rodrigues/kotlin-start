package com.rodrigues.silva.marcos.alugames.model

class Game(
    val title: String,
    val thumb: String,
    val price: Double
) {
    var description: String?  = ""

    constructor(title: String, thumb: String, price: Double, description: String) :
            this(title, thumb, price) {
                this.description = description
            }
    override fun toString(): String {
        return "Game(title='$title', thumb='$thumb', price='$price', description='$description')"
    }


}