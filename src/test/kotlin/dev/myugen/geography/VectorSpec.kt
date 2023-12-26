package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.South
import dev.myugen.direction.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class VectorSpec : WordSpec({
    "Vector" should {
        forAll(
            row(North, Vector(0, 1)),
            row(East, Vector(1, 0)),
            row(South, Vector(0, -1)),
            row(West, Vector(-1, 0)),
        ) { direction, expectedVector ->
            "create a corresponding for the $direction" {
                Vector.of(direction) shouldBe expectedVector
            }
        }
    }

})
