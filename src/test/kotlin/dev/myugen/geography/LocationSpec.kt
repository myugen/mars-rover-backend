package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class LocationSpec : WordSpec({
    "Location" should {
        "turn right" {
            val actual = LocationMother.origin.turnRight()

            actual shouldBe LocationMother.fixture { direction = East }
        }

        "turn left" {
            val actual = LocationMother.origin.turnLeft()

            actual shouldBe LocationMother.fixture { direction = West }
        }

        "moveForward" {
            val actual = LocationMother.origin.moveForward()

            actual shouldBe LocationMother.fixture { point { y = 1 } }
        }
    }

})
