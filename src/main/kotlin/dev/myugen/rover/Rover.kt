package dev.myugen.rover

import dev.myugen.geography.Location
import dev.myugen.geography.Path

class Rover private constructor(private val initialLocation: Location, private val planetSize: PlanetSize = PlanetSize(10,  10)) {

    var path: Path = listOf()
    fun execute(command: Command): Unit {
        path = command.calculatePathOver(currentLocation(), planetSize)
    }

    fun currentLocation(): Location {
        if (path.isEmpty()) return this.initialLocation;
        return path[path.size - 1]
    }

    companion object {
        fun landOnto(initialLocation: Location) = Rover(initialLocation)
    }
}