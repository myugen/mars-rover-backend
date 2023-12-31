package dev.myugen.rover

import arrow.core.left
import arrow.core.right
import dev.myugen.error.Failure

sealed interface Indication {
    fun executeOn(rover: Rover)

    data object TurnRight : Indication {
        override fun executeOn(rover: Rover) {
            rover.turnRight()
        }
    }

    data object TurnLeft : Indication {
        override fun executeOn(rover: Rover) {
            rover.turnLeft()
        }
    }

    data object MoveForward : Indication {
        override fun executeOn(rover: Rover) {
            rover.moveForward()
        }
    }

    companion object {
        fun of(value: Char) =
            when (value.uppercase()) {
                "R" -> TurnRight.right()
                "L" -> TurnLeft.right()
                "F" -> MoveForward.right()
                else -> IndicationFailure.NotExist(value).left()
            }
    }
}

sealed class IndicationFailure(override val reason: String) : Failure {
    data class NotExist(private val value: Char) : IndicationFailure(reason = "No exist indication for '$value'")
}
