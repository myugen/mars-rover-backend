package dev.myugen.common

interface Error {
    val reason: String
    val details: List<String>
}
