package dev.myugen.direction

sealed interface Direction {
    val onLeft: Direction
    val onRight: Direction
}
