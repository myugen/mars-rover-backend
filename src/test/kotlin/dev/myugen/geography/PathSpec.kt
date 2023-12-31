package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.geography.LocationMother.fixture
import dev.myugen.geography.LocationMother.origin
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class PathSpec : WordSpec({
    "Path" should {
        "add another location" {
            val path = Path.startsAt(origin)
            val anotherLocation = fixture { point { x = 5; y = 5 }; direction = East }

            path.add(anotherLocation)

            path.currentLocation shouldBe anotherLocation
        }
    }

})
