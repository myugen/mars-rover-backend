package dev.myugen.geography

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.South
import dev.myugen.direction.West
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class DirectionTest : ShouldSpec({
    context("turning right") {
        withData(
            nameFn = { "from ${it.first} should be ${it.second}" },
            Pair(North, East),
            Pair(East, South),
            Pair(South, West),
            Pair(West, North),
        ) { (currentDirection, expectedDirection) ->
            currentDirection.turnRight shouldBe expectedDirection
        }
    }

    context("turning left") {
        withData(
            nameFn = { "from ${it.first} should be ${it.second}" },
            Pair(North, West),
            Pair(West, South),
            Pair(South, East),
            Pair(East, North),
        ) { (currentDirection, expectedDirection) ->
            currentDirection.turnLeft shouldBe expectedDirection
        }
    }
})
