package com.rtu.bachelor.museumapp.data.api.models.cards

import com.rtu.bachelor.museumapp.util.Place
import java.util.*

data class AppointmentCard(
        val date: Date,
        val place: Place
) : AbstractCard("appointment")
