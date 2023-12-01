package dev.myugen.direction

sealed interface Direction {
    val turnLeft: Direction
    val turnRight: Direction
}
