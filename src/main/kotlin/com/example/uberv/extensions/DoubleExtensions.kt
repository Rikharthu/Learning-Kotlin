package com.example.uberv.extensions

// Extension properties
val Double.km: Double
    get() = this * 1_000.0

val Double.m: Double
    get() = this

val Double.cm: Double
    get() = this / 100.0

val Double.mm: Double
    get() = this / 1_000.0

val Double.ft: Double
    get() = this / 3.28084


// Extension function
fun Double.toPrice(currency: String) = "$currency: $this"