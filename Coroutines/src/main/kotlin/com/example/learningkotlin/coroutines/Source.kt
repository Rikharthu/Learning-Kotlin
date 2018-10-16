package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    // Can't call suspending function outside other suspending function or coroutine
    // createGreeting()

    val computation = async {
        println("Launching async function")
        createGreeting("John")
        println("Async function ended")

        thread {

        }
    }
    // await() can be a suspending function (hence also callable from within an async {} block)
    // that suspend a coroutine until some computation is done and returns it's result
    // computation.await()

    val computations = listOf(async { createGreeting("John") },
            async { createGreeting("John") },
            async { createGreeting("John") })

    // Suspending functions cannot be called from function literals that
    // are not inlined into a suspending function body
    async {
        // OK, forEach is an inline function, the lambda is inlined
        computations.forEach { it.await() }

        thread {
            // ERROR, thread is not an inline function, so the lambda is not inlined
            // createGreeting("Michael")
        }
    }
}

/**
 * Suspending functions may suspend a coroutine
 * They can only be called from other suspending functions
 * or inside coroutines
 */
suspend fun createGreeting(name: String): String {
    return "Hello, $name!"
}

suspend fun executeSuspendingLambda(block: suspend () -> Any) {
    block()
}