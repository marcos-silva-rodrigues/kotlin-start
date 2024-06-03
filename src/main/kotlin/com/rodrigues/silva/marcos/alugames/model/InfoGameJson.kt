package com.rodrigues.silva.marcos.alugames.model

import com.google.gson.annotations.SerializedName

data class InfoGameJson(
    @SerializedName("titulo")
    val title: String,
    @SerializedName("capa")
    val thumb: String,
    @SerializedName("preco")
    val price: Double,
    @SerializedName("descricao")
    val description: String)
