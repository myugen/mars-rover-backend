package dev.myugen.geography

import dev.myugen.common.Builder
import dev.myugen.common.Initializer
import dev.myugen.direction.Direction
import dev.myugen.direction.North

internal val Location.Companion.fixture: LocationFixture
    get() = LocationFixture

internal object LocationFixture : Initializer<Location, LocationBuilder> {
    /**
     * Create new [Location] using builder initialization, [LocationBuilder].
     *
     * Default: same as [LocationBuilder] default value.
     */
    override fun init(init: LocationBuilder.() -> Unit) = LocationBuilder().apply(init).build()

    /**
     * Origin location references [init] default value
     */
    val origin = init { }
}

/**
 * Builder for [Location].
 *
 * Default: [Point] as [PointFixture.origin] and [Direction] as [North]
 */
internal class LocationBuilder(
    private var builtPoint: Point = Point.fixture.origin,
    var facing: Direction = North
) : Builder<Location> {

    fun at(init: PointBuilder.() -> Unit) {
        builtPoint = PointBuilder().apply(init).build()
    }

    override fun build() = Location(builtPoint, facing)

}


