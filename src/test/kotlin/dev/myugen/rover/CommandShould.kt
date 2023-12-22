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

/*class CommandCalculationProvider : ArgumentsProvider {
    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of("turning right", "R", listOf(Location(Point(0, 0), East))),
            // Arguments.of("turning left", "L", listOf(Location(Point(0, 0), West))),

        )
    }
}*/

class CommandCalculationProviderForTurningRight : ArgumentsProvider {
    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(listOf(Location(Point(0, 0), East)), North),
            Arguments.of(listOf(Location(Point(0, 0), South)), East),
            Arguments.of(listOf(Location(Point(0, 0), West)), South),
            Arguments.of(listOf(Location(Point(0, 0), North)), West),
            // Arguments.of("R", listOf(Location(Point(0, 0), South)), East),
            // Arguments.of("turning left", "L", listOf(Location(Point(0, 0), West))),

        )
    }
}



class CommandShould {

    @ParameterizedTest(name = "calculate turning right from give current location when source direction is {1}")
    @ArgumentsSource(CommandCalculationProviderForTurningRight::class)
    fun `calculate path over`(expectedPath: Path, sourceDirection: Direction) {
        val command = Command("R")
        val currentLocation = Location(Point(0, 0), sourceDirection)
        val result = command.calculatePathOver(currentLocation)
        Assertions.assertEquals(expectedPath, result)
    }



    @Test
    fun `calculate turning left give current location when source direction is north`() {
        val command = Command("L")
        val currentLocation = Location(Point(0, 0), North)
        val result = command.calculatePathOver(currentLocation)
        val expected = listOf(Location(Point(0, 0), West))
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `calculate turning left give current location when source direction is west`() {
        val command = Command("L")
        val currentLocation = Location(Point(0, 0), West)
        val result = command.calculatePathOver(currentLocation)
        val expected = listOf(Location(Point(0, 0), South))
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `calculate turning left give current location when source direction is south`() {
        val command = Command("L")
        val currentLocation = Location(Point(0, 0), South)
        val result = command.calculatePathOver(currentLocation)
        val expected = listOf(Location(Point(0, 0), East))
        Assertions.assertEquals(expected, result)
    }
}