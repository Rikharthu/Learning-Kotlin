package com.example.uberv

fun main(args: Array<String>) {

    // Creating and manipulation a list
    var numbers =
            listOf(30 downTo -40, 300..310) // produces a list of 2 Range elements
                    .flatten()  // Converts all inner arrays and flattens
                    .sorted()   // Sorts the collection
                    .map { x -> x * 10 }    // Applies a function to each element and sets it
    numbers += 100500 // Add a new element
    // P.S. You could also do so: var numbers = (30 downTo -40) + (300..310)

    // Filtering a list
    val positives = numbers.filter { x -> x >= 0 }
    val negatives = numbers.filter { it < 0 }

    println("Numbers: $numbers")
    println("Positives: $positives")
    println("Negatives: $negatives")

    // Instance Checks
    val obj: Any = 1024L
    val type = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }
    println(type)

    // Traversing a map/list of pairs
//    for ((k, v) in map) {
//        println("$k -> $v")
//    }
}

// Creating DTOs (POJOs/POCOs)
/*
Provides a Customer class with the following functionality:
    —getters (and setters in case of vars) for all properties
    —equals()
    —hashCode()
    —toString()
    —copy()
    —component1(), component2(), …, for all properties (see Data classes https://kotlinlang.org/docs/reference/idioms.html)
 */
data class Customer(val name: String, val email: String)

// Default values for function parameters
fun foo(a: Int = 0, b: String = "") {
    println("a=$a, b=$b")
}