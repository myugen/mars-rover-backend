package dev.myugen.navigation

import dev.myugen.common.Builder
import dev.myugen.common.Initializer
import dev.myugen.spatial.*

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
     * Create location on given [Planet] with point in [PointFixture.origin] and facing [North]
     */
    fun origin(on: Planet) = init {
        this.on = on
    }
}

/**
 * Builder for [Location].
 *
 * Default: [Planet] with [PlanetFixture.noSize], [Point] in [PointFixture.origin] and [Direction] at [North]
 */
internal class LocationBuilder(
    var on: Planet = Planet.fixture.noSize,
    var facing: Direction = North,
    private var point: Point = Point.fixture.origin,
) : Builder<Location> {
    fun at(init: PointBuilder.() -> Unit) {
        point = PointBuilder().apply(init).build()
    }

    override fun build() = Location(on, point, facing)

}


