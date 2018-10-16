package com.rtu.bachelor.museumapp.data.api.models.cards


data class VideoCard(
        val title: String?,
        val video: String,
        val description: String?
) : AbstractCard("video")