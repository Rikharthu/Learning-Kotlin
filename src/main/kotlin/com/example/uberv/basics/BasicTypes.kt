package com.example.uberv.basics

fun main(args: Array<String>) {
    // Basic types:
    val types = mapOf(
            "Double" to 64,
            "Float" to 32,
            "Long" to 64,
            "Int\t" to 32,
            "Short" to 16,
            "Byte" to 8)
    println("Type\tBit width")
    println("_________________")
    for ((type, size) in types) {
        println("$type\t$size")
    }
}