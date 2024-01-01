package dev.myugen.geography

import arrow.optics.copy
import arrow.optics.optics
import dev.myugen.direction.Direction

@optics
data class Location(val at: Point, val facing: Direction) {
    companion object

    fun turnRight() = copy { Location.facing transform { it.onRight } }

    fun turnLeft() = copy { Location.facing transform { it.onLeft } }

    fun moveForward() = copy { Location.at transform { it.applies(Vector.of(facing)) } }
}
