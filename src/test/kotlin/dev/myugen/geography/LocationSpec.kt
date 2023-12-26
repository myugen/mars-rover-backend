package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class LocationSpec : WordSpec({
    "Location" should {
        "retrieve turned right location" {
            val location = Location(Point(0, 0), North)

            location.turnRight() shouldBe Location(Point(0, 0), East)
        }

        "retrieve turned left location" {
            val location = Location(Point(0, 0), North)

            location.turnLeft() shouldBe Location(Point(0, 0), West)
        }
    }

})
