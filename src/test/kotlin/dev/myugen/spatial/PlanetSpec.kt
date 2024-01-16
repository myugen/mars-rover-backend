package dev.myugen.spatial

import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class PlanetSpec : WordSpec({
    "Planet" should {
        "calculate limits from given even sizes" {
            val planet = Planet(6, 4)

            planet.horizontalLimit shouldBe Limit.Horizontal(-2, 3)
            planet.verticalLimit shouldBe Limit.Vertical(-1, 2)
        }

        "calculate limits from given odd sizes" {
            val planet = Planet(5, 7)

            planet.horizontalLimit shouldBe Limit.Horizontal(-2, 2)
            planet.verticalLimit shouldBe Limit.Vertical(-3, 3)
        }

        forAll(
            row("never crosses the limits", Planet(5, 5), Point(1, 1), Point(1, 1)),
            row("crosses the vertical limit from above", Planet(5, 5), Point(2, 3), Point(2, -2)),
            row("crosses the vertical limit from below", Planet(5, 5), Point(2, -3), Point(2, 2)),
            row("crosses the horizontal limit from right", Planet(5, 5), Point(3, 2), Point(-2, 2)),
            row("crosses the horizontal limit from left", Planet(5, 5), Point(-3, 2), Point(2, 2)),
        ) { testCase, currentPlanet, currentPoint, expectedPoint ->
            "normalize the point that $testCase" {
                val actualPoint = currentPlanet.normalize(currentPoint)

                actualPoint shouldBe expectedPoint
            }
        }
    }
})