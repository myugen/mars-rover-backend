package dev.myugen.rover

import dev.myugen.navigation.Location
import dev.myugen.navigation.fixture
import dev.myugen.spatial.East
import dev.myugen.spatial.North
import dev.myugen.spatial.Planet
import dev.myugen.spatial.West
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class RoverSpec : WordSpec({
    "Rover" should {
        forAll(
            row(
                "without crossing the limits",
                Location.fixture.origin(on = Planet(10, 10)),
                "LLFFFRFF",
                Location.fixture.init { on = Planet(10, 10); at { x = -2; y = -3 }; facing = West }),
            row(
                "crossing vertically from above",
                Location.fixture.origin(on = Planet(5, 5)),
                "FFRFLFFF",
                Location.fixture.init { on = Planet(5, 5); at { x = 1; y = 0 }; facing = North }),
        ) { testCase, initialLocation, commandValue, expectedLocation ->
            "receive command and move over the planet $testCase" {
                val rover = Rover.landsIn(initialLocation)
                val command = Command.of(value = commandValue).shouldBeRight()

                rover.execute(command)

                rover.currentLocation shouldBe expectedLocation
            }
        }

        "turn right" {
            val planet = Planet(width = 10, height = 10)
            val rover = Rover.landsIn(Location.fixture.origin(on = planet))

            rover.turnRight()

            rover.currentLocation shouldBe Location.fixture.init { on = Planet(10, 10); facing = East }
        }

        "turn left" {
            val planet = Planet(width = 10, height = 10)
            val rover = Rover.landsIn(Location.fixture.origin(on = planet))

            rover.turnLeft()

            rover.currentLocation shouldBe Location.fixture.init { on = Planet(10, 10); facing = West }
        }

        "move forward" {
            val planet = Planet(width = 10, height = 10)
            val rover = Rover.landsIn(Location.fixture.origin(on = planet))

            rover.moveForward()

            rover.currentLocation shouldBe Location.fixture.init { on = Planet(10, 10); at { y = 1 } }
        }
    }
})
