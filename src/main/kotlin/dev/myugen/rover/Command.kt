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

        if (value == "L") {
            if (currentLocation.direction == West) {
                return listOf(currentLocation.copy(direction = South))
            }
            if (currentLocation.direction == South) {
                return listOf(currentLocation.copy(direction = East))
            }
            if (currentLocation.direction == East) {
                return listOf(currentLocation.copy(direction = North))
            }

            return listOf(currentLocation.copy(direction = West))
        }

        return listOf(currentLocation.copy(direction = currentLocation.direction.turnRight))


        /*if (value=="L") {
            return  listOf(currentLocation.copy(direction = currentLocation.direction.turnLeft))
        }*/
    }
}