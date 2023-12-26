package dev.myugen.rover

import arrow.core.raise.either
import arrow.core.raise.ensure
import dev.myugen.common.Error

class Command private constructor(private val indications: Iterable<Indication>) {
    fun executeIndicationsOn(rover: Rover) {
        indications.forEach { it.executeOn(rover) }
    }

    companion object {
        fun of(value: String) = either {
            ensure(value.isNotBlank()) { EmptyCommandError }
            val incorrectIndications = mutableListOf<Error>()
            val validatedIndications = value.chars()
                .mapToObj { Char(it) }
                .toList()
                .map {
                    Indication.of(it)
                        .onLeft { incorrectIndications.add(it) }
                }
            ensure(incorrectIndications.isEmpty()) { InvalidCommandError.from(incorrectIndications) }

            Command(validatedIndications.map { it.bind() })
        }
    }
}

data object EmptyCommandError : Error {
    override val reason: String
        get() = ""
    override val details: List<String>
        get() = emptyList()
}

data class InvalidCommandError(
    override val reason: String,
    override val details: List<String> = emptyList()
) : Error {
    companion object {
        fun from(errors: Iterable<Error>) = InvalidCommandError(
            reason = "Invalid command",
            details = errors.map { it.reason }
        )
    }
}
