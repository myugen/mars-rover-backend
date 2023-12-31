package dev.myugen.rover

import arrow.core.getOrElse
import arrow.core.mapOrAccumulate
import arrow.core.raise.either
import arrow.core.raise.ensure
import dev.myugen.error.Failure

class Command private constructor(private val indications: Iterable<Indication>) {
    fun executeIndicationsOn(rover: Rover) {
        indications.forEach { it.executeOn(rover) }
    }

    companion object {
        fun of(value: String) = either {
            ensure(value.isNotBlank()) { CommandFailure.Empty }
            val validatedIndications = value.toList()
                .mapOrAccumulate { Indication.of(it).bind() }
                .mapLeft { CommandFailure.Invalid.from(it) }
                .getOrElse { raise(it) }

            Command(validatedIndications)
        }
    }
}

sealed class CommandFailure(override val reason: String, override val details: List<String> = emptyList()) : Failure {
    data object Empty : CommandFailure(reason = "Empty command")

    data class Invalid(override val details: List<String>) : CommandFailure(reason = "Invalid command") {
        companion object {
            fun from(errors: Iterable<Failure>) = Invalid(
                details = errors.map { it.reason }
            )
        }
    }
}
