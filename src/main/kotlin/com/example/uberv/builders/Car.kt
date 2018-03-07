package com.example.uberv.builders

// More info:
// https://stackoverflow.com/questions/36140791/how-to-implement-builder-pattern-in-kotlin
// https://kotlinlang.org/docs/reference/type-safe-builders.html
// https://kotlinlang.org/docs/reference/type-safe-builders.html#full-definition-of-the-comexamplehtml-package
class Car(
        val model: String?,
        val year: Int,
        val required: String
) {
    private constructor(builder: Builder) : this(builder.model, builder.year, builder.required)

    companion object {
        inline fun build(required: String, block: Builder.() -> Unit) = Builder(required).apply(block).build()
    }

    class Builder(
            val required: String
    ) {
        var model: String? = null
        var year: Int = 0
        fun build() = Car(this)
    }
}

fun main(args: Array<String>) {
    val car = Car.build(required = "requiredValue") { model = "X" }
}