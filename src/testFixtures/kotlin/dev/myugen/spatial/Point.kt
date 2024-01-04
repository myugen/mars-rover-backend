package dev.myugen.spatial

import dev.myugen.common.Builder

internal val Point.Companion.fixture: PointFixture
    get() = PointFixture

internal object PointFixture {
    /**
     * Origin point references [PointBuilder] default value
     */
    val origin = PointBuilder().build()
}

/**
 * Builder for [Point].
 *
 * Default: `(0, 0)`
 */
internal class PointBuilder(var x: Int = 0, var y: Int = 0) : Builder<Point> {
    override fun build() = Point(x, y)
}
