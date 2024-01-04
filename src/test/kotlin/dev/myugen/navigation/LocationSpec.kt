package dev.myugen.navigation

import dev.myugen.spatial.East
import dev.myugen.spatial.Planet
import dev.myugen.spatial.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class LocationSpec : WordSpec({
    "Location" should {
        "turn right" {
            val currentLocation = Location.fixture.origin(Planet(5, 5))
            val actual = currentLocation.turnRight()

            actual shouldBe Location.fixture.init { on = Planet(5, 5); facing = East }
        }

        "turn left" {
            val currentLocation = Location.fixture.origin(Planet(5, 5))
            val actual = currentLocation.turnLeft()

            actual shouldBe Location.fixture.init { on = Planet(5, 5); facing = West }
        }

        "moveForward" {
            val currentLocation = Location.fixture.origin(Planet(5, 5))
            val actual = currentLocation.moveForward()

            actual shouldBe Location.fixture.init { on = Planet(5, 5); at { y = 1 } }
        }
    }

})
