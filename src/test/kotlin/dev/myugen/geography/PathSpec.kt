package dev.myugen.geography

import dev.myugen.direction.East
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class PathSpec : WordSpec({
    "Path" should {
        "add another location" {
            val path = Path.startsAt(Location.fixture.origin)
            val anotherLocation = Location.fixture.init { at { x = 5; y = 5 }; facing = East }

            path.add(anotherLocation)

            path.currentLocation shouldBe anotherLocation
        }
    }

})
