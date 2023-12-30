package dev.myugen.geography

import dev.myugen.common.Builder

object PointMother {
    /**
     * Origin point references [PointBuilder] default value
     */
    val origin = PointBuilder().build()
}

/**
 * Builder for [Point]. Default value, (0, 0)
 */
class PointBuilder(var x: Int = 0, var y: Int = 0) : Builder<Point> {
    override fun build() = Point(x, y)
}
