package com.example.uberv.ranges

fun main(args: Array<String>) {
    val oneToTen = 1..10 // inclusive
    val oneToNine = 1 until 10 // non-inclusive

    for (i in oneToNine) {
        println("$i...")
    }
    // Reversed:
    for (i in 10 downTo 0) {
        println("$i...")
    }

    for (i in 1..100) {
        println(fizzBuzz(i))
    }


    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    // You can use an 'in' check to check whether a value is in a range, or opposite: '!in'
    val isLetter: (c: Char) -> Boolean = {
        it in 'a'..'z' || it in 'A'..'Z'
    }
    println(isLetter('F'))
    // true
    println(isLetter('4'))
    // false
    println(recognize('1'))
    println(recognize('Z'))
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "Fizzbuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…"
}