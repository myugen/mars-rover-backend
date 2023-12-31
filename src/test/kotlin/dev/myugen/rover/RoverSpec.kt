package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.West
import dev.myugen.geography.LocationMother
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class RoverSpec : WordSpec({
    "Rover" should {
        "receive commands and move over the planet" {
            val rover = Rover.landsOn(LocationMother.origin)
            val command = Command.of(value = "LLFFFRFF").shouldBeRight()

            rover.execute(command)

            rover.currentLocation shouldBe LocationMother.fixture {
                at { x = -2; y = -3 }
                facing = West
            }
        }

        "turn right" {
            val rover = Rover.landsOn(LocationMother.origin)

            rover.turnRight()

            rover.currentLocation shouldBe LocationMother.fixture { facing = East }
        }

        "turn left" {
            val rover = Rover.landsOn(LocationMother.origin)

            rover.turnLeft()

            rover.currentLocation shouldBe LocationMother.fixture { facing = West }
        }

        "move forward" {
            val rover = Rover.landsOn(LocationMother.origin)

            rover.moveForward()

            rover.currentLocation shouldBe LocationMother.fixture { at { y = 1 } }
        }
    }
})
