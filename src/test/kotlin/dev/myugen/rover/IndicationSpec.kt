package dev.myugen.rover

import io.kotest.assertions.arrow.core.shouldBeLeft
import io.kotest.assertions.arrow.core.shouldBeRight
import io.kotest.core.spec.style.WordSpec
import io.kotest.data.forAll
import io.kotest.data.row

internal class IndicationSpec : WordSpec({
    "Indication" should {
        forAll(
            row('R', TurnRightIndication),
            row('L', TurnLeftIndication),
            row('F', MoveForwardIndication),
        ) { value, expectedIndication ->
            "create a corresponding for $value" {
                Indication.of(value) shouldBeRight expectedIndication
            }
        }

        "fail when it does not exist corresponding one" {
            Indication.of('T') shouldBeLeft NoExistIndicationError(reason = "No exist indication for 'T'")
        }
    }
})
