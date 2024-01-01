package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.fixture
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class RoverSpec : WordSpec({
    "Rover" should {
        "receive commands and move over the planet" {
            val rover = Rover.landsOver(Location.fixture.origin)
            val command = Command.of(value = "LLFFFRFF").shouldBeRight()

            rover.execute(command)

            rover.currentLocation shouldBe Location.fixture.init {
                at { x = -2; y = -3 }
                facing = West
            }
        }

        "turn right" {
            val rover = Rover.landsOver(Location.fixture.origin)

            rover.turnRight()

            rover.currentLocation shouldBe Location.fixture.init { facing = East }
        }

        "turn left" {
            val rover = Rover.landsOver(Location.fixture.origin)

            rover.turnLeft()

            rover.currentLocation shouldBe Location.fixture.init { facing = West }
        }

        "move forward" {
            val rover = Rover.landsOver(Location.fixture.origin)

            rover.moveForward()

            rover.currentLocation shouldBe Location.fixture.init { at { y = 1 } }
        }
    }
})
