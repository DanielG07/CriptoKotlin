package com.danielg7.cripto.tutorial

/*
val begin = System.nanoTime()
        val arrayInput = arrayOf(
            3, 6, -2, -5, 7, 3, 4, 6, 1, 4, 5
        )
        println(solution(arrayInput))
        val end = System.nanoTime()
        println("Elapsed time in nanoseconds: ${end-begin}")
 */

fun solution(arrayInput: Array<Int>) : Int{
    var largestProduct = 0

    if(arrayInput.size in 2..10) {
        for(i in 0..(arrayInput.size-2)) {
            if(arrayInput[i] in -1000..1000){
                val aux = arrayInput[i]*arrayInput[i+1]
                if(largestProduct < aux) {
                    largestProduct = aux
                }
            } else {
                return -1
            }

        }
    } else {
        return -1
    }


    return largestProduct
}