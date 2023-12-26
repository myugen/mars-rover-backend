package dev.myugen.rover

data class Command(private val value: String) {
    fun executeIndicationsOn(rover: Rover) =
        value.uppercase().map {
            when (it) {
                'R' -> rover.turnRight()
                'L' -> rover.turnLeft()
                'F' -> rover.moveForward()
                else -> throw NoSuchElementException("Command $it not valid")
            }
        }
}
