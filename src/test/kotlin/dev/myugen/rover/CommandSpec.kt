package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Point
import io.kotest.assertions.arrow.core.shouldBeLeft
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class CommandSpec : WordSpec({
    "Command" should {
        "fail when is empty" {
            Command.of("") shouldBeLeft EmptyCommandError
        }

        "fail when command has not existing indication" {
            Command.of("LGFFTRRM") shouldBeLeft InvalidCommandError(
                reason = "Invalid command",
                details = listOf(
                    "No exist indication for 'G'",
                    "No exist indication for 'T'",
                    "No exist indication for 'M'",
                )
            )
        }

        forAll(
            row("turning right", "R", Location(Point(0, 0), North), Location(Point(0, 0), East)),
            row("turning left", "L", Location(Point(0, 0), North), Location(Point(0, 0), West)),
            row("moving forward", "F", Location(Point(0, 0), North), Location(Point(0, 1), North)),
        ) { indication, commandValue, currentLocation, expectedLocation ->
            "execute $indication on rover" {
                val rover = Rover.landOnto(currentLocation)
                val command = Command.of(commandValue).shouldBeRight()

                command.executeIndicationsOn(rover)

                rover.currentLocation() shouldBe expectedLocation
            }
        }
    }
})
