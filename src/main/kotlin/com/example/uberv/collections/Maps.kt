package com.example.uberv.collections

import java.util.*

fun main(args: Array<String>) {
    // Iteratinп over maps
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
    /*
    // Pair entry
    for (entry in binaryReps) {
        println("$entry")
    }

    for(letter in binaryReps.keys){...}
    for(binary in binaryReps.values){...}
    */

    val map = mapOf(1 to "One", 7 to "Seven", 53 to "Fifty-three")
    // 'to' is an infix function that creates pair of values
    // Absolutely the same as:
    val map2 = mapOf(Pair(1, "One"), Pair(7, "Seven"), Pair(53, "Fifty-three"))
}