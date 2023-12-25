package dev.myugen.rover

import dev.myugen.direction.North
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Point
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class RoverTest : WordSpec({
    "Rover" should {
        "receive commands and move over the planet" {
            val rover = Rover.landOnto(Location(Point(0, 0), North))

            rover.execute(Command("LLFFFRFF"))

            rover.currentLocation() shouldBe Location(Point(-2, -3), West)
        }
    }
})
