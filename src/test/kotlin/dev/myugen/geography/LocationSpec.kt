package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class LocationSpec : WordSpec({
    "Location" should {
        "turn right" {
            val location = Location(Point(0, 0), North)

            location.turnRight() shouldBe Location(Point(0, 0), East)
        }

        "turn left" {
            val location = Location(Point(0, 0), North)

            location.turnLeft() shouldBe Location(Point(0, 0), West)
        }
    }

})
