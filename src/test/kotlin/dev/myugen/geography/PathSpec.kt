package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.North
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class PathSpec : WordSpec({
    "Path" should {
        "add another location" {
            val path = Path.startsAt(Location(Point(0, 0), North))
            val anotherLocation = Location(Point(2, 5), East)

            path.add(anotherLocation)

            path.currentLocation() shouldBe anotherLocation
        }
    }

})
