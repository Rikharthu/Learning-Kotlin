package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.ContinuationInterceptor

fun main(args: Array<String>) = runBlocking<Unit> {
    // Coroutine context is just a map of coroutine-local parameters, such as interceptor, and etc
    launch {
        val job = coroutineContext[Job]!!
        val interceptor = coroutineContext[ContinuationInterceptor]!!
        val x = 4
    }
}