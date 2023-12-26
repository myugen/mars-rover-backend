package dev.myugen.geography

import dev.myugen.direction.Direction

data class Location(val point: Point, val direction: Direction) {
    fun turnRight() = copy(direction = direction.onRight)

    fun turnLeft() = copy(direction = direction.onLeft)
}
