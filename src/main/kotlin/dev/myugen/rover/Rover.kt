package dev.myugen.rover

import dev.myugen.geography.Location
import dev.myugen.geography.Path

class Rover private constructor(private val initialLocation: Location) {
    fun execute(commands: Commands): Unit {
        val path: Path = commands.calculatePathOver(currentLocation())
    }

    fun currentLocation(): Location = TODO("Current location not implemented")

    companion object {
        fun landOnto(initialLocation: Location) = Rover(initialLocation)
    }
}