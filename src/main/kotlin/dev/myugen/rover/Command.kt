package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.South
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Path
import dev.myugen.geography.Point

data class Command(private val value: String) {
    fun calculatePathOver(currentLocation: Location): Path {

        if (value == "F") {
            if (currentLocation.direction == East) {
                val currentXvalue = currentLocation.point.x
                return listOf(currentLocation.copy(point = currentLocation.point.copy(x = currentXvalue + 1)))
            }
            val currentYvalue = currentLocation.point.y
            return listOf(currentLocation.copy(point = currentLocation.point.copy(y = currentYvalue + 1)))
        }
        if (value == "L") {
            return listOf(currentLocation.copy(direction = currentLocation.direction.turnLeft))
        }

        return listOf(currentLocation.copy(direction = currentLocation.direction.turnRight))
    }
}