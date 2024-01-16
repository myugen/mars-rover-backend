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

    fun moveForward() = copy { Location.at transform { point -> on.normalize(point.applies(Vector.of(facing))) } }
}
