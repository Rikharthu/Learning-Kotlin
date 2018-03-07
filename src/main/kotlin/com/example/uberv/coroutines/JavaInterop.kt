package com.example.learningkotlin.coroutines

import com.example.uberv.coroutines.JavaInterop

fun main(args: Array<String>) {

}

fun dosmth() {
    val future1 = JavaInterop.loadName()
    val future2 = JavaInterop.loadGreeting()
}