package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.West
import dev.myugen.geography.LocationMother
import io.kotest.assertions.arrow.core.shouldBeLeft
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class CommandSpec : WordSpec({
    "Command" should {
        "fail when is empty" {
            Command.of("") shouldBeLeft CommandFailure.Empty
        }

        "fail when command has not existing indication" {
            Command.of("LGFFTRRM") shouldBeLeft CommandFailure.Invalid(
                details = listOf(
                    "No exist indication for 'G'",
                    "No exist indication for 'T'",
                    "No exist indication for 'M'",
                )
            )
        }

        forAll(
            row("turning right", "R", LocationMother.origin, LocationMother.fixture { facing = East }),
            row("turning left", "L", LocationMother.origin, LocationMother.fixture { facing = West }),
            row("moving forward", "F", LocationMother.origin, LocationMother.fixture { at { y = 1 } }),
        ) { indication, commandValue, currentLocation, expectedLocation ->
            "execute $indication on rover" {
                val rover = Rover.landsOver(currentLocation)
                val command = Command.of(commandValue).shouldBeRight()

                command.executeIndicationsOn(rover)

                rover.currentLocation shouldBe expectedLocation
            }
        }
    }
})
