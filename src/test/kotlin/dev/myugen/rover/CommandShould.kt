package dev.myugen.rover

import dev.myugen.direction.*
import dev.myugen.geography.Location
import dev.myugen.geography.Path
import dev.myugen.geography.Point
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class CommandCalculationProvider : ArgumentsProvider {
    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(listOf(Location(Point(0, 0), East)), North, "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), South)), East, "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), West)), South, "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), North)), West, "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), West)), North, "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), South)), West, "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), East)), South, "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), North)), East, "L", "turning left")
        )
    }
}

class CommandShould {

    @ParameterizedTest(name = "calculate {3} from give current location when source direction is {1}")
    @ArgumentsSource(CommandCalculationProvider::class)
    fun `calculate path over 1`(expectedPath: Path, sourceDirection: Direction, commandValue: String, commandName: String) {
        val command = Command(commandValue)
        val currentLocation = Location(Point(0, 0), sourceDirection)
        val result = command.calculatePathOver(currentLocation)
        Assertions.assertEquals(expectedPath, result)
    }
}