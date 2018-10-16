package com.example.uberv.functions.receivers

fun main(args: Array<String>) {

    val intToLong: Int.() -> Long = { toLong() }

    val xInt = 4
    val xLong = intToLong(xInt)
    println(xInt::class.java)
    println(xLong::class.java)

    val html = html {
        body()
        p()
        p(false)
        p()
        p(false)
        p()
        p(false)
        body(false)
    }
    println("HTML:\n$html")

    val html2 = html2 {
        it.body()
        it.p()
        it.p(false)
        it.p()
        it.p(false)
        it.p()
        it.p(false)
        it.body(false)
    }
    println("\nHTML2:\n$html2")
}

class HTML {
    private var padding: Int = 0
    private val builder = StringBuilder()

    fun body(open: Boolean = true) {
        builder.appendln(wrapTag("body", open))
    }

    fun p(open: Boolean = true) {
        builder.appendln(wrapTag("p", open))
    }

    private fun wrapTag(text: String, open: Boolean = true): String {
        return if (open) {
            "<$text>"
        } else {
            "</$text>"
        }
    }

    override fun toString() = builder.toString()
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init() // or init(html)
    return html
}

fun html2(init: (HTML) -> Unit): HTML {
    val html = HTML()
    init(html)
    return html
}