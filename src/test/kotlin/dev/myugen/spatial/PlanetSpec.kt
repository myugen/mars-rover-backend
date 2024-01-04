package dev.myugen.spatial

import io.kotest.core.spec.style.WordSpec
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
    }
})
