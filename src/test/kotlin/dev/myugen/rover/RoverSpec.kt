package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Point
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class RoverSpec : WordSpec({
    "Rover" should {
        "receive commands and move over the planet" {
            val rover = Rover.landOnto(Location(Point(0, 0), North))

            rover.execute(Command("LLFFFRFF"))

            rover.currentLocation() shouldBe Location(Point(-2, -3), West)
        }

        "turn right" {
            val rover = Rover.landOnto(Location(Point(0, 0), North))

            rover.turnRight()

            rover.currentLocation() shouldBe Location(Point(0, 0), East)
        }

        "turn left" {
            val rover = Rover.landOnto(Location(Point(0, 0), North))

            rover.turnLeft()

            rover.currentLocation() shouldBe Location(Point(0, 0), West)
        }

        "move forward" {
            val rover = Rover.landOnto(Location(Point(0, 0), North))

            rover.moveForward()

            rover.currentLocation() shouldBe Location(Point(0, 1), North)
        }
    }
})
