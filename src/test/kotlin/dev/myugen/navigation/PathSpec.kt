package dev.myugen.navigation

import dev.myugen.spatial.East
import dev.myugen.spatial.Planet
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class PathSpec : WordSpec({
    "Path" should {
        "add another location" {
            val path = Path.startsAt(Location.fixture.origin(Planet(5, 5)))
            val anotherLocation = Location.fixture.init {
                on = Planet(5, 5)
                at { x = 2; y = 3 }
                facing = East
            }

            path.add(anotherLocation)

            path.currentLocation shouldBe anotherLocation
        }
    }

})
