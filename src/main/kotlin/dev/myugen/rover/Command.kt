package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.South
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Path

data class Command(private val value: String) {
    fun calculatePathOver(currentLocation: Location, planetSize: PlanetSize): Path {

        if (value == "F") {
            return turnFront(currentLocation, planetSize)
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

    private fun turnFront(currentLocation: Location, planetSize: PlanetSize): List<Location> {
        val INITIAL_COORDINATE_VALUE_IN_BOTH_AXES = 0
        val DIFFERENCE_VALUE_BETWEEN_COORDINATES = 1

        fun withFacingWest(): List<Location> {
            var xValue = currentLocation.point.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.x == INITIAL_COORDINATE_VALUE_IN_BOTH_AXES) {
                xValue = planetSize.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES;
            }
            return listOf(currentLocation.copy(point = currentLocation.point.copy(x = xValue)))
        }

        fun withFacingEast(): List<Location> {
            var xValue = currentLocation.point.x + DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.x == planetSize.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES) {
                xValue = INITIAL_COORDINATE_VALUE_IN_BOTH_AXES;
            }
            return listOf(currentLocation.copy(point = currentLocation.point.copy(x = xValue)))
        }

        fun withFacingNorth(): List<Location> {
            var yValue = currentLocation.point.y + DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.y == planetSize.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES) {
                yValue = INITIAL_COORDINATE_VALUE_IN_BOTH_AXES;
            }
            return listOf(currentLocation.copy(point = currentLocation.point.copy(y = yValue)))
        }

        fun withFacingSouth(): List<Location> {
            var yValue = currentLocation.point.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.y == INITIAL_COORDINATE_VALUE_IN_BOTH_AXES) {
              yValue = planetSize.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES;
            }
            return listOf(currentLocation.copy(point = currentLocation.point.copy(y = yValue)))
        }

        if (currentLocation.direction == South) {
            return withFacingSouth()
        }

        if (currentLocation.direction == West) {
            return withFacingWest()
        }

        if (currentLocation.direction == East) {
            return withFacingEast()
        }

        return withFacingNorth()
    }


}