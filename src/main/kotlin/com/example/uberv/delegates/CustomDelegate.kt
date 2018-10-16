package com.example.uberv.delegates

import kotlin.reflect.KProperty

class Holder {
    var delegatedProperty: String by Delegate()
}

fun main(args: Array<String>) {
    val holder = Holder()
    println(holder.delegatedProperty)
    holder.delegatedProperty = "Hello, World!"
    println(holder.delegatedProperty)
}

/*
The syntax is: val/var <property name>: <Type> by <expression>.
The expression after by is the delegate, because get() (and set())
corresponding to the property will be delegated to its getValue()
and setValue() methods. Property delegates don’t have to implement any interface,
but they have to provide a getValue() function (and setValue() — for vars).

For example:
 */

// Declare on your own or implement ReadWriteProperty/ReadOnlyProperty
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}