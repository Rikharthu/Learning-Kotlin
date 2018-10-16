package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")

    Thread.sleep(2000)

    // Roughly identical to:
    // Except in this case thread is blocked, while delay() doesn't block thread
    thread {
        Thread.sleep(1000L)
        println("World!")
    }

    runBlocking {
        println("This will block the thread until coroutine completes")
        delay(2000L)
        println("runBlocking finished")
    }

    // runBlock can also return a value (if not specified it is Unit)
    val result = runBlocking {
        println("Preparing greeting...")
        delay(2000L)
        return@runBlocking "Hello, World!"
    }
    println("Result: $result")
}