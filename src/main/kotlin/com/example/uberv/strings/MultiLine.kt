package com.example.uberv.strings

fun main(args: Array<String>) {
    // Triple-quoted strings can contain any characted, including line breaks
    // It avoids escaping
    val kotlinLogo = """| //
                       .|//
                       .|/ \""".trimMargin(".")
    // trimMargin is used to trim the indentation of the subsequent lines
    println(kotlinLogo)

    val path1 = "C:\\Users\\yole\\kotlin-book" // needs escaping
    val path2 = """C:\Users\yole\kotlin-book""" // no escaping needed

    println("""$99.9""")
}