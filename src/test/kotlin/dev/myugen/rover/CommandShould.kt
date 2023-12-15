package dev.myugen.rover

import dev.myugen.direction.East
import dev.myugen.direction.North
import dev.myugen.direction.West
import dev.myugen.geography.Location
import dev.myugen.geography.Path
import dev.myugen.geography.Point
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
            Arguments.of("turning right", "R", listOf(Location(Point(0, 0), East))),
            Arguments.of("turning left", "L", listOf(Location(Point(0, 0), West))),

        )
    }
}
class CommandShould {

    @ParameterizedTest(name = "calculate {0} from give current location")
    @ArgumentsSource(CommandCalculationProvider::class)
    fun `calculate path over`(name: String, commandValue: String, expectedPath: Path) {
        val command = Command(commandValue)
        val currentLocation = Location(Point(0, 0), North)
        val result = command.calculatePathOver(currentLocation)
        Assertions.assertEquals(result, expectedPath)
    }
}