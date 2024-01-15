package dev.myugen.spatial

import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class PlanetSpec : WordSpec({
    "Planet" should {
        "calculate limits from given even sizes" {
            val planet = Planet(6, 4)

            planet.maxX shouldBe 3
            planet.minX shouldBe -2
            planet.maxY shouldBe 2
            planet.minY shouldBe -1
        }

        "calculate limits from given odd sizes" {
            val planet = Planet(5, 7)

            planet.maxX shouldBe 2
            planet.minX shouldBe -2
            planet.maxY shouldBe 3
            planet.minY shouldBe -3
        }

        forAll(
            row("never crosses the limits", Planet(5, 5), Point(1, 1), Point(1, 1)),
            row("crosses the vertical limit from above", Planet(5, 5), Point(2, 3), Point(2, -2)),
            row("crosses the vertical limit from below", Planet(5, 5), Point(2, -3), Point(2, 2)),
        ) { testCase, currentPlanet, currentPoint, expectedPoint ->
            "determine the current position of a point that $testCase" {
                val actualPoint = currentPlanet.determineCurrentPositionOf(currentPoint)

                actualPoint shouldBe expectedPoint
            }
        }
    }
})
