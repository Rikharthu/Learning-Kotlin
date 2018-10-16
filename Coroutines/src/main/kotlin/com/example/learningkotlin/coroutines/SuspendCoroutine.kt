package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.suspendCoroutine

fun main(args: Array<String>) = runBlocking {
    println("Running...")
    println("Making first call")
    val callResult1 = doNetworkCall("https://www.google.com")
    println("Call result 1: $callResult1")

    try {
        // Will throw exception
        println("Making second call")
        val callResult2 = doNetworkCall("git://www.google.com")
        println("Call result 2: $callResult2")
    } catch (e: Throwable) {
        println("Got error: $e")
    }
}

suspend fun doNetworkCall(url: String): String = suspendCoroutine {
    val api = Api()
    api.callApi(url, object : Api.Callback {
        override fun onSuccess(data: String) {
            it.resume(data)
        }

        override fun onError(error: Throwable) {
            it.resumeWithException(error)
        }
    })
}

sealed class Result
data class Error(val error: Throwable) : Result()
data class Success(val data: String) : Result()

class Api {

    fun callApi(url: String, callback: Callback) {
        Thread {
            Thread.sleep(1500)
            if (url.startsWith("http")) {
                callback.onSuccess("<p>Hello, World!</p>")
            } else {
                callback.onError(Throwable("Network call failed"))
            }
        }.start()
    }

    interface Callback {
        fun onSuccess(data: String)
        fun onError(error: Throwable)
    }
}