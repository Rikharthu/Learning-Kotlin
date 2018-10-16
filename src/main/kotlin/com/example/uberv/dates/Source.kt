package com.example.uberv.dates

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {

    val dateString = "2018-07-23T01:49:39-07:00"
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date = format.parse(dateString)
    val calendar = Calendar.getInstance()
    calendar.time = date

    val today = Calendar.getInstance()
    val isSameDay = isSameDay(calendar, today)

    val timestamp1 = calendar.timeInMillis
    val timestamp2 = today.timeInMillis
    val isSameDay2 = isSameDay(timestamp1, timestamp2)

    val x = 4
}

fun isSameDay(cal1: Calendar, cal2: Calendar): Boolean {
    return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
            cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
            cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
}

fun isSameDay(timestamp1: Long, timestamp2: Long): Boolean {
    return isSameDay(Calendar.getInstance().apply { timeInMillis = timestamp1 },
            Calendar.getInstance().apply { timeInMillis = timestamp2 })
}