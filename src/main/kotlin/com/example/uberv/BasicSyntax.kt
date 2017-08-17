package com.example.uberv

import java.lang.Math.pow

/**
 * This is a KDOC comment
 * [args] something
 * @param args some command-line arguments
 * @author Vasja Pupkin
 */
fun main(args: Array<String>) {
    // This is an end of line comment
    /* This is a block comment
       on multiple lines
       /* Nested block comment (not supported in java*/
       val y=4   */

    // val - Assign-one (read-only) variables
    val a: Int = 7 // immediate assignment
    val b = 3     // Int type is inferred
    val c: Int   // Type required when no initializer is provided
    c = -6
    // c=20 Error! val cannot be reassigned!

    // var - Mutable variable
    var x = 14
    x += 1
    println("x=$x")

    printSum(a, b)
    printSub(a, b)

    x = sum(a, b)
    println("x=$a+$b=$x")

    /* Using string templates */
    var u = 1
    // Simple name in template
    val s1 = "a is $u"
    println(s1)

    u = 2
    // arbitrary expression in template:
    val s2 = "${s1.replace("is", "was")}, but now is $u"
    println(s2)

    println("Maximum of $a and $b is ${maxOf(a, b)}")
    println("Minimum of $a and $b is ${minOf(a, b)}")

    printProduct("Azazin", "32")

    println("Length of \"$s2\" is ${getStringLength(s2)}")
    println("Length of \"$x\" is ${getStringLength(x) ?: "unknown"}")

    /* Using a for loop */
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    // or
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    // loop through range
    for (i in 1..100) {
        println("range: $i")
    }
    /*
    Same as Java's
    for(int i=1;i<101;i++){
        . . .
    }
     */

    // Using a while loop
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    // Checking if collection contains an object usin in operator:
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
    // Use lambda expressions to filter and map collections
    // get all fruits that start with 'a', sort them in alphabetic order, make them upperCase and print
    items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    /* Using a when expression */
    println(describe(1))
    println(describe("Hello"))
    println(describe(256L))
    println(describe(256))
    println(describe(Unit))

    /* using ranges */
    x = 10
    val y = 9
    // Check if a number is within a range using in operator:
    if (x in 1..y + 1) { // [1, y+1]
        println("fits in range")
    }

    // Check if number is out of range
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
    // Iterate over a range
    for (x in 1..5) {
        println(x)
    }

    println("137 in binary is ${toBinaryString(137)}")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int) = a - b
//fun sub(a: Int, b: Int):Int = a - b // specifying return type is possible

fun printSum(a: Int, b: Int): Unit { // Unit = void in Java
//    println("sum of $a and $b is ${a + b}")
    println("sum of $a and $b is ${sum(a, b)}")
}

fun printSub(a: Int, b: Int) {
    println("sub of $a and $b is ${sub(a, b)}")
}

/**
 * Demonstration of using a conditional expressions.
 * Returns max of passed [Int] arguments: either [a] or [b]
 *
 * @param a first [Int] parameter
 * @param b second [Int] parameter
 * @return [a] if [a] > [b], [b] otherwise
 */
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// uses if-expression body
// More info https://kotlinlang.org/docs/reference/control-flow.html#if-expression
fun minOf(a: Int, b: Int) = if (a < b) a else b

fun parseInt(str: String): Int? { // mark this function that it can return null
    // A reference must be explicitly marked as nullable when null value is possible.
    // question mark allows this type to be a null
    var result: Int?
    try {
        result = Integer.parseInt(str)
    } catch(e: NumberFormatException) {
        result = null
    }
    return result
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    // The is operator checks if an expression is an instance of a type.
    // If an immutable local variable or property is checked for a specific type,
    // there's no need to cast it explicitly
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

// Or
/*
fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}
*/

// Or even
/*
fun getStringLength(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}
*/

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun toBinaryString(number: Int): String {
    var tmp = number
    var powers = mutableListOf<Int>()
    for (x in 15 downTo 0) {
        powers.add(pow(2.0, x.toDouble()).toInt())
    }
    var sb = StringBuilder()
    var remainder: Int
    var isPrinting = false
    for (power in powers) {
        remainder = tmp / power
        tmp = tmp % power
        if (remainder > 0) {
            isPrinting = true
        }
        if (isPrinting) {
            sb.append(remainder)
        }
    }

    return sb.toString()
}