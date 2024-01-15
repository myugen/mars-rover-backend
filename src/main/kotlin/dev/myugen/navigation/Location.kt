package dev.myugen.navigation

import arrow.optics.copy
import arrow.optics.optics
import dev.myugen.spatial.Direction
import dev.myugen.spatial.Planet
import dev.myugen.spatial.Point
import dev.myugen.spatial.Vector

@optics
data class Location(val on: Planet, val at: Point, val facing: Direction) {
    companion object

    fun turnRight() = copy { Location.facing transform { it.onRight } }

    fun turnLeft() = copy { Location.facing transform { it.onLeft } }

    fun moveForward() = copy { Location.at transform { on.determineCurrentPositionOf(it.applies(Vector.of(facing))) } }
}
