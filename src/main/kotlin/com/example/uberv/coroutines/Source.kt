package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.coroutines.experimental.buildSequence

fun main(args: Array<String>) {
    println("Start")

    // Start a coroutine
    launch {
        // Similar to Thread.sleep(), but it doesn't block a thread,
        // but only suspends the coroutine itself.
        delay(1000)
        println("Hello")
    }

    // Wait for our coroutine to execute before exiting
    Thread.sleep(2000)
    println("Stop")

    // delay() is only meant to be used inside coroutine:
    // delay(1000) // Error: Suspend functions are only allowed to be called from a coroutine or another suspend function
    // To use delay, wrap it inside runBlocking coroutine:
    // runBlocking runs a code block the execution thread it's called
    runBlocking {
        delay(2000)
    }
    println("runBlocking finished")

    launchThreads()
    launchCoroutines()

    // Fibonacci numbers:
    val fibonacci = buildSequence {
        var cur: Long = 1
        var next: Long = 1
        while (true) {
            // yield is a suspending function that lets return the next result of the sequence
            yield(cur)
            val tmp = cur + next
            cur = next
            next = tmp
        }
    }
    val iter = fibonacci.iterator()
    println("First 20 Fibonacci numbers")
    for (i in 0..30) {
        println(iter.next())
    }
}

fun launchThreads() {
    println("Launching 100.000 threads")
    val c = AtomicInteger()
    val timeStart = System.currentTimeMillis()
    for (i in 1..100_000) {
        thread(start = true) {
            c.addAndGet(i)
        }
    }
    val timeEnd = System.currentTimeMillis()
    println("Counter: ${c.get()}, time taken: ${(timeEnd - timeStart) / 1000}s")
}

fun launchCoroutines() {
    println("Launching 100.000 coroutines")
    val c = AtomicInteger()
    val timeStart = System.currentTimeMillis()
    for (i in 1..100_000) {
        launch {
            c.addAndGet(i)
        }
    }
    val timeEnd = System.currentTimeMillis()
    println("Counter: ${c.get()}, time taken: ${(timeEnd - timeStart) / 1000}s")
}