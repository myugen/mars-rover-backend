package dev.myugen.rover

import dev.myugen.geography.Location
import dev.myugen.geography.Path

class Rover private constructor(private val initialLocation: Location, private val planetSize: PlanetSize = PlanetSize(10,  10)) {
    fun execute(command: Command): Unit {
        val path: Path = command.calculatePathOver(currentLocation(), planetSize)
    }

    fun currentLocation(): Location = TODO("Current location not implemented")

    companion object {
        fun landOnto(initialLocation: Location) = Rover(initialLocation)
    }
}