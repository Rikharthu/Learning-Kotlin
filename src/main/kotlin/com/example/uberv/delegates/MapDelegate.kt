package com.example.uberv.delegates

class Person(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

class MutableUser(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int     by map
}

fun main(args: Array<String>) {
    val person = Person(mapOf(
            "name" to "John Doe",
            "age" to 25
    ))

    println(person.name) // Prints "John Doe"
    println(person.age)  // Prints 25

    val map = mutableMapOf<String, Any?>(
            "name" to "John Doe",
            "age" to 25
    )
    val mutableUser = MutableUser(map)
    println(mutableUser.name) // Prints "John Doe"
    println(mutableUser.age)
    println(map)
    mutableUser.name="Adolf Hitler"
    println(mutableUser.name)
    println(mutableUser.age)
    // Map is also edited
    println(map)
}