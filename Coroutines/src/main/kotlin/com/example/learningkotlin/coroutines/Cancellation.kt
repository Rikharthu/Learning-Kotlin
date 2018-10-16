package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.suspendCancellableCoroutine

fun main(args: Array<String>) = runBlocking<Unit> {
    val cancellableJob = launch {
        while (isActive) {
            println("Cancellable: doing something...")
            delay(500)
        }
        println("Cancellable: ended")
    }
    val eternalJob = launch {
        while (true) {
            println("Eternal: doing something...")
            delay(500)
        }
        println("Eternal: ended")
    }
    delay(3000)

    println("Cancelling jobs")
    cancellableJob.cancel()
    eternalJob.cancel()

    suspendCancellableCoroutine<String> {
        it.resume("Hello, World!")
        it.invokeOnCompletion {
            println("Completed")
        }
    }

    delay(30000)
}