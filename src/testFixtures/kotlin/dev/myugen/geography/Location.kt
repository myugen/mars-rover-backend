package dev.myugen.geography

import dev.myugen.common.Builder
import dev.myugen.common.Initializer
import dev.myugen.direction.Direction
import dev.myugen.direction.North

object LocationMother : Initializer<Location, LocationBuilder> {
    /**
     * Create new [Location] using builder initialization, [LocationBuilder].
     * Default value, same as [LocationBuilder] default value
     */
    override fun fixture(init: LocationBuilder.() -> Unit) = LocationBuilder().apply(init).build()

    /**
     * Origin location references [fixture] default value
     */
    val origin = fixture { }
}

/**
 * Builder for [Location]. Default value, [Point] as [PointMother.origin] and [Direction] as [North]
 */
class LocationBuilder(
    private var builtPoint: Point = PointMother.origin,
    var facing: Direction = North
) : Builder<Location> {

    fun at(init: PointBuilder.() -> Unit) {
        builtPoint = PointBuilder().apply(init).build()
    }

    override fun build() = Location(builtPoint, facing)

}


