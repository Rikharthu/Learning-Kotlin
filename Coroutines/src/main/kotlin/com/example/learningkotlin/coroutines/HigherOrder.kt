package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.io.IOException
import java.util.concurrent.ThreadLocalRandom

fun main(args: Array<String>) {

    launch {
        val post = retryIO {
            if (ThreadLocalRandom.current().nextInt(100) > 90) {
                return@retryIO "Hello, World!"
            } else {
                throw IOException("Could not generate greeting")
            }
        }
        println("Post: $post")
    }
    readLine()
}

suspend fun <T> retryIO(block: suspend () -> T): T {
    var curDelay = 1000L
    while (true) {
        try {
            return block()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        delay(curDelay)
        curDelay = (curDelay * 2).coerceAtMost(60000L)
    }
}