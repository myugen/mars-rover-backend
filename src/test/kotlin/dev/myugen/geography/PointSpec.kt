package dev.myugen.geography

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
    }

})
