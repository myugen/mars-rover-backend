package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.South
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Path

data class Command(private val value: String) {

    fun calculatePathOver(currentLocation: Location, planetSize: PlanetSize): Path {
        val myList: MutableList<Location> = mutableListOf()
        var currentLocationAux: Location = currentLocation
        for (item in this.value) {
            if (item == 'B') {
                currentLocationAux = goBackwards(currentLocationAux, planetSize)
                myList.add(currentLocationAux)
            }

            if (item == 'F') {
                currentLocationAux = turnFront(currentLocationAux, planetSize)
                myList.add(currentLocationAux)
            }

            if (item == 'L') {
                currentLocationAux = turnLeft(currentLocationAux)
                myList.add(currentLocationAux)
            }

            if (item == 'R') {
                currentLocationAux = turnRight(currentLocationAux)
                myList.add(currentLocationAux)
            }
        }

        return myList.toList()
    }

    private fun goBackwards(currentLocation: Location, planetSize: PlanetSize): Location {
        val INITIAL_COORDINATE_VALUE_IN_BOTH_AXES = 0
        val DIFFERENCE_VALUE_BETWEEN_COORDINATES = 1

        fun withFacingWest(): Location {
            return currentLocation.copy(point = currentLocation.point.copy(x = currentLocation.point.x + 1))
        }

        fun withFacingEast(): Location {
            var xValue = currentLocation.point.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.x == INITIAL_COORDINATE_VALUE_IN_BOTH_AXES) {
                xValue = planetSize.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES;
            }
            return currentLocation.copy(point = currentLocation.point.copy(x = xValue))
        }

        fun withFacingSouth(): Location {
            return currentLocation.copy(point = currentLocation.point.copy(y = currentLocation.point.y + 1))
        }

        if (currentLocation.direction == South) {
            return withFacingSouth()
        }

        if (currentLocation.direction == East) {
            return withFacingEast()
        }

        if (currentLocation.direction == West) {
            return withFacingWest()
        }

        var yValue = currentLocation.point.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES
        if (currentLocation.point.y == INITIAL_COORDINATE_VALUE_IN_BOTH_AXES) {
            yValue = planetSize.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES;
        }
        return currentLocation.copy(point = currentLocation.point.copy(y = yValue))
    }

    private fun turnRight(currentLocation: Location) = currentLocation.copy(direction = currentLocation.direction.turnRight)

    private fun turnLeft(currentLocation: Location): Location = currentLocation.copy(direction = currentLocation.direction.turnLeft)

    private fun turnFront(currentLocation: Location, planetSize: PlanetSize): Location {
        val INITIAL_COORDINATE_VALUE_IN_BOTH_AXES = 0
        val DIFFERENCE_VALUE_BETWEEN_COORDINATES = 1

        fun withFacingWest(): Location {
            var xValue = currentLocation.point.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.x == INITIAL_COORDINATE_VALUE_IN_BOTH_AXES) {
                xValue = planetSize.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES;
            }
            return currentLocation.copy(point = currentLocation.point.copy(x = xValue))
        }

        fun withFacingEast(): Location {
            var xValue = currentLocation.point.x + DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.x == planetSize.x - DIFFERENCE_VALUE_BETWEEN_COORDINATES) {
                xValue = INITIAL_COORDINATE_VALUE_IN_BOTH_AXES;
            }
            return currentLocation.copy(point = currentLocation.point.copy(x = xValue))
        }

        fun withFacingNorth(): Location {
            var yValue = currentLocation.point.y + DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.y == planetSize.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES) {
                yValue = INITIAL_COORDINATE_VALUE_IN_BOTH_AXES;
            }
            return currentLocation.copy(point = currentLocation.point.copy(y = yValue))
        }

        fun withFacingSouth(): Location {
            var yValue = currentLocation.point.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES
            if (currentLocation.point.y == INITIAL_COORDINATE_VALUE_IN_BOTH_AXES) {
                yValue = planetSize.y - DIFFERENCE_VALUE_BETWEEN_COORDINATES;
            }
            return currentLocation.copy(point = currentLocation.point.copy(y = yValue))
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