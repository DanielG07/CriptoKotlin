package com.danielg7.cripto.tutorial

interface IEstudiante {
    fun estudiar(materia: String)
    fun reprobar(materia: String)
}

class Daniel(
    val materias: List<String>
) : IEstudiante {

    fun materias() {
        materias.forEach { materia ->
            println("Esta estudiando $materia")
        }
    }

    override fun estudiar(materia: String) {
        println("Esta estudiando $materia")
    }

    override fun reprobar(materia: String) {
        println("Reprobo $materia")
    }
}
