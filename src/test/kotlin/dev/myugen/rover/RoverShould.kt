package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.South
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RoverShould {

    @Test
    fun `receive commands and move over the planet`() {
        val rover = Rover.landOnto(Location(Point(0, 0), North))

        rover.execute(Command("LLFFFRFFRBBRBBRBRBLFLFLFLF"))

        Assertions.assertEquals(rover.currentLocation(), Location(Point(7, 6), West))
    }

}

