package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Point
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class CommandSpec : WordSpec({
    "Command" should {
        forAll(
            row("turning right", "R", Location(Point(0, 0), North), Location(Point(0, 0), East)),
            row("turning left", "L", Location(Point(0, 0), North), Location(Point(0, 0), West)),
            row("moving forward", "F", Location(Point(0, 0), North), Location(Point(0, 1), North)),
        ) { indication, commandValue, currentLocation, expectedLocation ->
            "execute $indication on rover" {
                val rover = Rover.landOnto(currentLocation)
                val command = Command(commandValue)

                command.executeIndicationsOn(rover)

                rover.currentLocation() shouldBe expectedLocation
            }
        }
    }
})
