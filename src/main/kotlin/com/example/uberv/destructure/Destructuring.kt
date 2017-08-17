package com.example.uberv.destructure

fun main(args: Array<String>) {
    val p: Person = Person("Vasja", "Pupkin", 33);
    val c = Person("Gosha", "Tortilla", 0, p);

    val (name, surname, age) = p

    println("$name, $surname, $age")
}