package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class LocationSpec : WordSpec({
    "Location" should {
        "turn right" {
            val actual = LocationMother.origin.turnRight()

            actual shouldBe LocationMother.fixture { facing = East }
        }

        "turn left" {
            val actual = LocationMother.origin.turnLeft()

            actual shouldBe LocationMother.fixture { facing = West }
        }

        "moveForward" {
            val actual = LocationMother.origin.moveForward()

            actual shouldBe LocationMother.fixture { at { y = 1 } }
        }
    }

})
