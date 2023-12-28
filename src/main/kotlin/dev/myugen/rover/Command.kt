package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.South
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Path

data class Command(private val value: String) {
    fun calculatePathOver(currentLocation: Location, planetSize: PlanetSize = PlanetSize(x = 10, y = 10)): Path {

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
        fun withFacingWest(): List<Location> {
            var xValue = currentLocation.point.x - 1
            if (currentLocation.point.x == 0) {
                xValue = planetSize.x - 1;
            }
            return listOf(currentLocation.copy(point = currentLocation.point.copy(x = xValue)))
        }

        fun withFacingEast(): List<Location> {
            val xValue = currentLocation.point.x + 1
            return listOf(currentLocation.copy(point = currentLocation.point.copy(x = xValue)))
        }

        fun withFacingNorth(): List<Location> {
            val yValue = currentLocation.point.y + 1
            return listOf(currentLocation.copy(point = currentLocation.point.copy(y = yValue)))
        }
        fun withFacingSouth(): List<Location> {
            val yValue = currentLocation.point.y - 1
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