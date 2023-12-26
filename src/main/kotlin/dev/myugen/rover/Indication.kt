package dev.myugen.rover

import arrow.core.left
import arrow.core.right
import dev.myugen.common.Error

sealed interface Indication {
    fun executeOn(rover: Rover)

    companion object {
        fun of(value: Char) =
            when (value.uppercase()) {
                "R" -> TurnRightIndication.right()
                "L" -> TurnLeftIndication.right()
                "F" -> MoveForwardIndication.right()
                else -> NoExistIndicationError.of(value).left()
            }
    }
}

data object TurnRightIndication : Indication {
    override fun executeOn(rover: Rover) {
        rover.turnRight()
    }
}

data object TurnLeftIndication : Indication {
    override fun executeOn(rover: Rover) {
        rover.turnLeft()
    }
}

data object MoveForwardIndication : Indication {
    override fun executeOn(rover: Rover) {
        rover.moveForward()
    }
}

data class NoExistIndicationError(
    override val reason: String,
    override val details: List<String> = emptyList()
) : Error {
    companion object {
        fun of(value: Char) = NoExistIndicationError(reason = "No exist indication for '$value'")
    }
}
