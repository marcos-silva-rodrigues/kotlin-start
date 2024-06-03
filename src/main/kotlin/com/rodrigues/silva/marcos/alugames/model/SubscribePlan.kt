package com.rodrigues.silva.marcos.alugames.model

class SubscribePlan(
    type: String,
    val monthly: Double,
    val games: Int) : Plan(type)
