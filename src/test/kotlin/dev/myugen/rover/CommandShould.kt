package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.South
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Path
import dev.myugen.geography.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
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
            Arguments.of(listOf(Location(Point(1, 3), North)), Location(Point(1, 2), North), "F", "turning front"),
            Arguments.of(listOf(Location(Point(1, 0), East)), Location(Point(0, 0), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(2, 0), East)), Location(Point(1, 0), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(3, 0), East)), Location(Point(2, 0), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(2, 1), East)), Location(Point(1, 1), East), "F", "turning front"),
            Arguments.of(listOf(Location(Point(1, 0), West)), Location(Point(2, 0), West), "F", "turning front"),
            Arguments.of(listOf(Location(Point(0, 0), West)), Location(Point(1, 0), West), "F", "turning front"),
            Arguments.of(listOf(Location(Point(1, 1), West)), Location(Point(2, 1), West), "F", "turning front"),
            Arguments.of(listOf(Location(Point(0, 0), South)), Location(Point(0, 1), South), "F", "turning front"),
            Arguments.of(listOf(Location(Point(0, 1), South)), Location(Point(0, 2), South), "F", "turning front"),
            Arguments.of(listOf(Location(Point(1, 2), South)), Location(Point(1, 3), South), "F", "turning front"),
            Arguments.of(listOf(Location(Point(0, 0), East)), Location(Point(0, 0), North), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), South)), Location(Point(0, 0), East), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), West)), Location(Point(0, 0), South), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), North)), Location(Point(0, 0), West), "R", "turning right"),
            Arguments.of(listOf(Location(Point(0, 0), West)), Location(Point(0, 0), North), "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), South)), Location(Point(0, 0), West), "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), East)), Location(Point(0, 0), South), "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), North)), Location(Point(0, 0), East), "L", "turning left"),
            Arguments.of(listOf(Location(Point(0, 0), North)), Location(Point(0, 1), North), "B", "go backwards"),
            Arguments.of(listOf(Location(Point(1, 1), North)), Location(Point(1, 2), North), "B", "go backwards"),
            Arguments.of(listOf(Location(Point(1, 0), West)), Location(Point(0, 0), West), "B", "go backwards"),
            Arguments.of(listOf(Location(Point(2, 1), West)), Location(Point(1, 1), West), "B", "go backwards"),
            Arguments.of(listOf(Location(Point(0, 0), East)), Location(Point(1, 0), East), "B", "go backwards"),
            Arguments.of(listOf(Location(Point(1, 1), East)), Location(Point(2, 1), East), "B", "go backwards"),
            Arguments.of(listOf(Location(Point(0, 1), South)), Location(Point(0, 0), South), "B", "go backwards"),
            Arguments.of(listOf(Location(Point(1, 2), South)), Location(Point(1, 1), South), "B", "go backwards"),
            Arguments.of(
                listOf(Location(Point(0, 1), North), Location(Point(0, 2), North)),
                Location(Point(0, 0), North),
                "FF",
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), West), Location(Point(0, 0), South)),
                Location(Point(0, 0), North),
                "LL",
                "turning left"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), East), Location(Point(0, 0), South)),
                Location(Point(0, 0), North),
                "RR",
                "turning right"
            ),
        )
    }
}

class CommandCalculationProviderForEdges : ArgumentsProvider {
    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(
                listOf(Location(Point(9, 0), West)),
                Location(Point(0, 0), West),
                "F",
                PlanetSize(10, 10),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(19, 0), West)),
                Location(Point(0, 0), West),
                "F",
                PlanetSize(20, 10),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), East)),
                Location(Point(9, 0), East),
                "F",
                PlanetSize(10, 10),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), East)),
                Location(Point(19, 0), East),
                "F",
                PlanetSize(20, 10),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), North)),
                Location(Point(0, 9), North),
                "F",
                PlanetSize(10, 10),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), North)),
                Location(Point(0, 19), North),
                "F",
                PlanetSize(10, 20),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 9), South)),
                Location(Point(0, 0), South),
                "F",
                PlanetSize(10, 10),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 19), South)),
                Location(Point(0, 0), South),
                "F",
                PlanetSize(10, 20),
                "turning front"
            ),
            Arguments.of(
                listOf(Location(Point(0, 9), North)),
                Location(Point(0, 0), North),
                "B",
                PlanetSize(10, 10),
                "go backwards"
            ),
            Arguments.of(
                listOf(Location(Point(0, 19), North)),
                Location(Point(0, 0), North),
                "B",
                PlanetSize(10, 20),
                "go backwards"
            ),
            Arguments.of(
                listOf(Location(Point(9, 0), East)),
                Location(Point(0, 0), East),
                "B",
                PlanetSize(10, 10),
                "go backwards"
            ),
            Arguments.of(
                listOf(Location(Point(19, 0), East)),
                Location(Point(0, 0), East),
                "B",
                PlanetSize(20, 10),
                "go backwards"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), West)),
                Location(Point(9, 0), West),
                "B",
                PlanetSize(10, 10),
                "go backwards"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), West)),
                Location(Point(19, 0), West),
                "B",
                PlanetSize(20, 10),
                "go backwards"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), South)),
                Location(Point(0, 9), South),
                "B",
                PlanetSize(10, 10),
                "go backwards"
            ),
            Arguments.of(
                listOf(Location(Point(0, 0), South)),
                Location(Point(0, 19), South),
                "B",
                PlanetSize(10, 20),
                "go backwards"
            ),
        )
    }
}

class CommandShould {

    @ParameterizedTest(name = "calculate {3} from give current location when source direction is {1}")
    @ArgumentsSource(CommandCalculationProviderAlt::class)
    fun `calculate path over`(expectedPath: Path, sourceLocation: Location, commandValue: String, commandName: String) {
        val command = Command(commandValue)
        val planetSize = PlanetSize(10, 10)
        val result = command.calculatePathOver(sourceLocation, planetSize)

        Assertions.assertEquals(expectedPath, result)
    }

    @Nested
    @DisplayName("with edges")
    inner class WithEdges {
        @ParameterizedTest(name = "calculate {4} from give current location when source direction is {1}")
        @ArgumentsSource(CommandCalculationProviderForEdges::class)
        fun `calculate path over edge`(
            expectedPath: Path,
            sourceLocation: Location,
            commandValue: String,
            planetSize: PlanetSize,
            commandName: String
        ) {
            val command = Command(commandValue)
            val result = command.calculatePathOver(sourceLocation, planetSize)

            Assertions.assertEquals(expectedPath, result)
        }

    }
}