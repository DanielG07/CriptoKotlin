package com.danielg7.cripto.tutorial

fun tablas() {
    val tablas = 1..10
    tablas.forEach {
        println("----- Tabla del $it -----")
        for (i in 1..10) {
            println("$it * $i = ${it*i}")
        }
    }

    // Opcion 2
    val tablaUno = Tabla(1)
    tablaUno.imprimirTabla()

    val tablaDos = Tabla(2)
    tablaDos.imprimirTabla()

    val tablaOnce = Tabla(11)
    tablaOnce.imprimirTabla()

}

class Tabla (val numero: Int){
    fun imprimirTabla() {
        println("----- Tabla del $numero -----")
        for (i in 1..10) {
            println("$numero * $i = ${numero*i}")
        }
    }
}