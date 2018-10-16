package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.future.await
import kotlinx.coroutines.experimental.future.future
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

// Part of coroutines-integration
// https://github.com/Kotlin/kotlinx.coroutines/blob/master/integration/README.md

fun main(args: Array<String>) = runBlocking<Unit> {
    val greetingFuture = future {
        delay(3000)
        return@future "Hello, World!"
    }
    println(greetingFuture.await())
}