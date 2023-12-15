package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.geography.Location
import dev.myugen.geography.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CommandShould {
    @Test
    fun `calculate turning right from given current location`() {

        val command = Command("R")
        val currentLocation = Location(Point(0, 0), North)
        val result = command.calculatePathOver(currentLocation)
        val expectedPath = listOf(Location(Point(0, 0), East))
        Assertions.assertEquals(result, expectedPath)
    }
}