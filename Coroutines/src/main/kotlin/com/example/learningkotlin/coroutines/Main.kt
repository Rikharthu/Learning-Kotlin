package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {

    val task = async {
        delay(1000)
        return@async "Hello, World!"
    }

    launch {
        val greeting = task.await()
        println(greeting)
    }

    println("Press 'enter' to exit")
    readLine()
}