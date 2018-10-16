package com.example.uberv.exceptions

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) {
    // You can use 'try' as an expression
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("Not a number"))
    readNumber(reader)
}