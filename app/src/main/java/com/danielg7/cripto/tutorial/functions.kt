package com.danielg7.cripto.tutorial


/**
 * Return sum of 2 numbers
 * @param a int operator
 * @param b int operator
 * @return int result
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumExpression(a: Int, b: Int) = a + b

fun sumParams(a: Int = 3, b: Int): Int {
    return a + b
}

fun palindrome(cad: String): Boolean {
    println(cad.reversed())
    return cad == cad.reversed()
}

fun palindromeFor(cad: String): Boolean {
    var aux: String = ""

    for (i in cad.length.downTo(0)) {
        println("Letra ${cad[i]}")
        aux += cad[i] + ""
    }

    if (aux == cad) {
        return true
    }

    return false
}