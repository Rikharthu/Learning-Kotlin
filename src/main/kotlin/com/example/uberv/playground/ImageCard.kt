package com.rtu.bachelor.museumapp.data.api.models.cards



data class ImageCard(
        val title: String?,
        val image: String,
        val description: String?
) : AbstractCard("image")