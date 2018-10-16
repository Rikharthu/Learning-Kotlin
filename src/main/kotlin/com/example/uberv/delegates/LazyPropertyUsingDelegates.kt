package com.example.uberv.delegates

/*
lazy() is a function that takes a lambda and returns an instance of Lazy<T>
which can serve as a delegate for implementing a lazy property: the first call to get()
executes the lambda passed to lazy() and remembers the result, subsequent calls to get()
simply return the remembered result.
 */

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}

fun main(args: Array<String>) {
    val lazyProp = LazyPropertyUsingDelegates {
        println("Initializer called")
        return@LazyPropertyUsingDelegates 10050
    }
    println("lazyProp created")
    println("Accessing it's lazyValue...")
    val lazyValue1 = lazyProp.lazyValue
    println("Accessing it's lazyValue again...")
    val lazyValue2 = lazyProp.lazyValue
    println("lazyValue: $lazyValue1, $lazyValue2")
}