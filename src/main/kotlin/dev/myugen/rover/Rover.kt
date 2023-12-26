package dev.myugen.rover

import dev.myugen.geography.Location
import dev.myugen.geography.Path

class Rover private constructor(private val travelledPath: Path) {
    fun execute(command: Command) {
        command.executeIndicationsOn(this)
    }

    fun currentLocation(): Location = travelledPath.currentLocation()

    fun turnRight() {
        val currentLocation = currentLocation()
        travelledPath.add(currentLocation.copy(direction = currentLocation.direction.onRight))
    }

    companion object {
        fun landOnto(initialLocation: Location) = Rover(Path.startsAt(initialLocation))
    }
}
