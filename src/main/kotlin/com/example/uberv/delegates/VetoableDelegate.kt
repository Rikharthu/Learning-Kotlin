package com.example.uberv.delegates

import kotlin.properties.Delegates

// vetoable() delegate is the same as observable(), but allows to "veto" (restrict) change to field

class Employee {

    var name: String by Delegates.vetoable("<no name>") { prop, old, new ->
        // called only upon assignment
        println("$old -> $new")
        // You can't cal lyour employee an 'asshole'!
        return@vetoable new!="asshole"
    }
}

fun main(args: Array<String>) {
    val employee = Employee()
    employee.name = "first"
    println(employee.name)
    employee.name = "asshole"
    println(employee.name)
}