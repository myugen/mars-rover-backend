package dev.myugen.spatial

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class PointSpec : WordSpec({
    "Point" should {
        "apply a vector" {
            val vector = Vector(1, 0)
            val point = Point(-4, 5)

            val actual = point.applies(vector)

            actual shouldBe Point(-3, 5)
        }

        "normalize based on limits" {
            val horizontalLimit = Limit.Horizontal(-2, 2)
            val verticalLimit = Limit.Vertical(-1, 1)
            val point = Point(3, 4)

            val actual = point.normalizesBy(listOf(verticalLimit, horizontalLimit))

            actual shouldBe Point(-2, 1)
        }
    }

})
