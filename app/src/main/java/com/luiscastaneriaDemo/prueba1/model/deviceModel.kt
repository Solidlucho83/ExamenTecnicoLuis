package com.luiscastaneriaDemo.prueba1.model

data class deviceModel(
    val brand: String,
    val id: String,
    val images: List<ImageX>,
    val legal: String,
    val mainImage: MainImageX,
    val name: String
)