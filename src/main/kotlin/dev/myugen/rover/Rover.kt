package dev.myugen.rover

import dev.myugen.geography.Location
import dev.myugen.geography.Path

class Rover private constructor(private val travelledPath: Path) {
    val currentLocation: Location
        get() = travelledPath.currentLocation

    fun execute(command: Command) {
        command.executeIndicationsOn(this)
    }

    fun turnRight() {
        val turnedRightLocation = currentLocation.turnRight()
        travelledPath.add(turnedRightLocation)
    }

    fun turnLeft() {
        val turnedLeftLocation = currentLocation.turnLeft()
        travelledPath.add(turnedLeftLocation)
    }

    fun moveForward() {
        val forwardedLocation = currentLocation.moveForward()
        travelledPath.add(forwardedLocation)
    }

    companion object {
        fun landsOver(initialLocation: Location) = Rover(Path.startsAt(initialLocation))
    }
}
