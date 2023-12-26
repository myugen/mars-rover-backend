package dev.myugen.rover

import dev.myugen.geography.Location
import dev.myugen.geography.Path

class Rover private constructor(private val travelledPath: Path) {
    fun execute(command: Command) {
        command.executeIndicationsOn(this)
    }

    fun currentLocation(): Location = travelledPath.currentLocation()

    fun turnRight() {
        val turnedRightLocation = currentLocation().turnRight()
        travelledPath.add(turnedRightLocation)
    }

    fun turnLeft() {
        val turnedLeftLocation = currentLocation().turnLeft()
        travelledPath.add(turnedLeftLocation)
    }

    companion object {
        fun landOnto(initialLocation: Location) = Rover(Path.startsAt(initialLocation))
    }
}
