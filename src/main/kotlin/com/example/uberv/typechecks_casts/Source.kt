package com.example.uberv.typechecks_casts

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun main(args: Array<String>) {
    // (1+2)+4
    val expression = Sum(Sum(Num(1), Num(2)), Num(4))
    println(eval(expression))
}

fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value    // e is being smart-cast to Num
            is Sum -> eval(e.right) + eval(e.left)    // e is being smart-cast to Sum
            else -> throw IllegalArgumentException("Unknown expression")
        }
