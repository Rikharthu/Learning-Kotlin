package com.example.uberv.inheritance

fun main(args: Array<String>) {
    val appSettings: IAppSettings = MapAppSettings()

    val token1 = appSettings.token
    val token11 = appSettings.token ?: "default-value"
    appSettings.token = "abcdefg123"
    val token2 = appSettings.token
    println("token1: $token1, token2: $token2, token11: $token11")
}