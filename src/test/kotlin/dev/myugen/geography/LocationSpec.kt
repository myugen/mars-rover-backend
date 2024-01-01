package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class LocationSpec : WordSpec({
    "Location" should {
        "turn right" {
            val actual = Location.fixture.origin.turnRight()

            actual shouldBe Location.fixture.init { facing = East }
        }

        "turn left" {
            val actual = Location.fixture.origin.turnLeft()

            actual shouldBe Location.fixture.init { facing = West }
        }

        "moveForward" {
            val actual = Location.fixture.origin.moveForward()

            actual shouldBe Location.fixture.init { at { y = 1 } }
        }
    }

})
