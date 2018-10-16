package com.example.learningkotlin.coroutines

import kotlin.coroutines.experimental.buildSequence

fun main(args: Array<String>) {
    val fibonacci = buildSequence {
        var cur = 1
        var next = 1
        while (true) {
            yield(cur)
            val tmp = cur + next
            cur = next
            next = tmp
        }
    }


    val firstTen = fibonacci.take(10).toList()
    val anotherTen = fibonacci.take(10).toList()

    println(firstTen)
    println(anotherTen) // same

    val iter = fibonacci.iterator()
    for (i in 1..20) {
        println("$i: ${iter.next()}")
    }

//    for (i in fibonacci) {
//        println(i)
//    }
//    fibonacci
}