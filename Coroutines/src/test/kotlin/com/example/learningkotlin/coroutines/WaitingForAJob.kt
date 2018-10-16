package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    // Launch a new coroutine and keep a reference to its job
    val job = launch {
        delay(1000L)
        println("World!")
    }
    print("Hello, ")
    job.join() // Wait until child coroutine completes
}