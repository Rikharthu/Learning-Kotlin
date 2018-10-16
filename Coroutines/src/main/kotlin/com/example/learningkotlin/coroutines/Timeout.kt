package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) = runBlocking {
    launch {
        withTimeout(3, TimeUnit.SECONDS) {
            delay(2, TimeUnit.SECONDS)
            println("Finished")
        }
        println("launch: end")
    }.join()
    println("main: end")
}