package com.example.uberv.functions

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    // Define a local function
    fun validate(value: String,
                 fieldName: String) {
        // It has access to all parameters of the enclosing function/scope
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                    "Cannot save user ${user.id}: $fieldName is empty")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
    // Save user to the database
}

fun main(args: Array<String>) {
    saveUser(User(1, "John", ""))
}