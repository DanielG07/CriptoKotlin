package com.danielg7.cripto.tutorial

class ProgramadorPython(
    val programingLanguage: String,
    var favoriteIde: String
) {
    fun develop() {
        println("Estoy desarrollando")
    }
}

class ProgramadorJS(
    val programingLanguage: String = "JS",
    var favoriteIde: String
) {
    fun develop() {
        println("Estoy desarrollando")
    }
}

interface IDeveloper {
    fun code()
}

interface IManager {
    fun ask()
}

class FullStackDeveloper(private val programingLanguages: List<String>) : IDeveloper, IManager {
    override fun code() {
        TODO("Not yet implemented")
    }

    override fun ask() {
        TODO("Not yet implemented")
    }
}

class AndroidDeveloper() {
    var language: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }
}
