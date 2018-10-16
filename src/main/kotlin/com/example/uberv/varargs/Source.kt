package com.example.uberv.varargs

fun insertAll(vararg values: String) {
    // 'values' is Array<String> here
    for (element in values) {
        println("Inserting \'$element\'")
    }
}

fun main(args: Array<String>) {
    insertAll("Apple", "Orange", "Melon")

    val fruits = arrayOf("Banana", "Pineapple", "Dragon's fruit")
    // insertAll(fruits) // Error, must unpack array first
    // * is a spread operator
    insertAll(*fruits)
    // Spread operator lets combine arrays with values:
    insertAll(*fruits, "Orange", "Kiwi")

    val berries = listOf("Cherry", "Blackthorn", "Blackberries", "Yew berry")
    insertAll(*berries.toTypedArray())
}