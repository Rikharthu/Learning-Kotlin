package com.example.uberv.extensions

// You can change the name of the class or function you're importing using the 'as' keyword
import com.example.uberv.extensions.cm as centimeters

fun main(args: Array<String>) {
    val oneInch = 25.4.mm
    println("One inch is $oneInch meters")
    val threeFeet = 3.0.ft
    println("Three feet is $threeFeet meters")

    println("Three feed is ${threeFeet.centimeters} centimeters")

    println(2.0.toPrice("EUR"))
}