package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.geography.Location
import dev.myugen.geography.Path
import dev.myugen.geography.Point

data class Command(private val value: String) {
    fun calculatePathOver(currentLocation: Location): Path {
        if (value=="R") {
            return  listOf(currentLocation.copy(direction = currentLocation.direction.turnRight))
        }
        throw RuntimeException("Invalid command")
    }
}