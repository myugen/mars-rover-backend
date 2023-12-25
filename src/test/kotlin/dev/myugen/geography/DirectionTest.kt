package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.South
import dev.myugen.direction.West
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DirectionTest : WordSpec({
    listOf(
        row(North, East, West),
        row(East, South, North),
        row(South, West, East),
        row(West, North, South),
    ).map { (currentDirection, expectedRightDirection, expectedLeftDirection) ->
        "$currentDirection" should {
            "have $expectedRightDirection on its right" {
                currentDirection.onRight shouldBe expectedRightDirection
            }

            "have $expectedLeftDirection on its left" {
                currentDirection.onLeft shouldBe expectedLeftDirection
            }
        }
    }
})
