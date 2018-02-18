package com.example.learningkotlin.coroutines

import kotlinx.coroutines.experimental.delay

fun main(args: Array<String>) {

}

/*
he biggest merit of coroutines is that they can suspend without blocking a thread.
The compiler has to emit some special code to make this possible,
so we have to mark functions that may suspend explicitly in the code.
We use the suspend modifier for it
 */
suspend fun workload(n: Int): Int {
    delay(1000)
    return n
}