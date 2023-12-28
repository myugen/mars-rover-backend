package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.South
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Path
import dev.myugen.geography.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class CommandCalculationProviderAlt : ArgumentsProvider {
    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(listOf(Location(Point(0, 1), North)), Location(Point(0, 0), North), "F", "turning front"),
            Arguments.of(listOf(Location(Point(0, 2), North)), Location(Point(0, 1), North), "F", "turning front"),
            Arguments.of(listOf(Location(Point(0, 3), North)), Location(Point(0, 2), North), "F", "turning front"),
            Arguments.of(listOf(Location(Point(0, 0), East)), Location(Point(0, 0), North), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), South)), Location(Point(0, 0), East), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), West)), Location(Point(0, 0), South), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), North)), Location(Point(0, 0), West), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), West)), Location(Point(0, 0), North), "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), South)), Location(Point(0, 0), West), "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), East)), Location(Point(0, 0), South), "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), North)), Location(Point(0, 0), East), "L", "turning left"),
            Arguments.of(listOf(Location(Point(1, 0), East)), Location(Point(0, 0), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(2, 0), East)), Location(Point(1, 0), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(3, 0), East)), Location(Point(2, 0), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(2, 1), East)), Location(Point(1, 1), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(1, 0), West)), Location(Point(2, 0), West), "F", "turning front"),
        )
    }
}

class CommandShould {

    @ParameterizedTest(name = "calculate {3} from give current location when source direction is {1}")
    @ArgumentsSource(CommandCalculationProviderAlt::class)
    fun `calculate path over`(expectedPath: Path, sourceLocation: Location, commandValue: String, commandName: String) {
        val command = Command(commandValue)

        val result = command.calculatePathOver(sourceLocation)

        Assertions.assertEquals(expectedPath, result)
    }
}