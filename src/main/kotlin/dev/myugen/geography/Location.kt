package dev.myugen.geography

import dev.myugen.direction.Direction

data class Location(val at: Point, val facing: Direction) {
    fun turnRight() = copy(facing = facing.onRight)

    fun turnLeft() = copy(facing = facing.onLeft)

    fun moveForward() = copy(at = at.applies(Vector.of(facing)))
}
