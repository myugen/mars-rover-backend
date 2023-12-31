package dev.myugen.error

interface Failure {
    val reason: String
    val details: List<String>
        get() = emptyList()
}
