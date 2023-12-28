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
            return turnFront(currentLocation)
        }
        if (value == "L") {
            return turnLeft(currentLocation)
        }

        return turnRight(currentLocation)
    }

    private fun turnRight(currentLocation: Location) =
        listOf(currentLocation.copy(direction = currentLocation.direction.turnRight))

    private fun turnLeft(currentLocation: Location): List<Location> {
        return listOf(currentLocation.copy(direction = currentLocation.direction.turnLeft))
    }

    private fun turnFront(currentLocation: Location): List<Location> {
        fun withFacingWest(): List<Location> {
            val currentXvalue = currentLocation.point.x
            return listOf(currentLocation.copy(point = currentLocation.point.copy(x = currentXvalue - 1)))
        }

        fun withFacingEast(): List<Location> {
            val currentXvalue = currentLocation.point.x
            return listOf(currentLocation.copy(point = currentLocation.point.copy(x = currentXvalue + 1)))
        }

        if (currentLocation.direction == West) {
            return withFacingWest()
        }

        if (currentLocation.direction == East) {
            return withFacingEast()
        }
        val currentYvalue = currentLocation.point.y
        return listOf(currentLocation.copy(point = currentLocation.point.copy(y = currentYvalue + 1)))
    }
}