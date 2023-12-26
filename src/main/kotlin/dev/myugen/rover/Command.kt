package dev.myugen.rover

data class Command(private val value: String) {
    fun executeIndicationsOn(rover: Rover) =
        when (value.uppercase()) {
            "R" -> rover.turnRight()
            "L" -> rover.turnLeft()
            else -> TODO()
        }
}
