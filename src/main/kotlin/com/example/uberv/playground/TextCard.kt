package com.rtu.bachelor.museumapp.data.api.models.cards


data class TextCard(
        val content: List<TextItem>
) : AbstractCard("text") {
    data class TextItem(val type: String, val text: String)
}