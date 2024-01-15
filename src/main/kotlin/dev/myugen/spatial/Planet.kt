package dev.myugen.spatial

import arrow.optics.copy
import arrow.optics.optics

@optics
data class Planet(val width: Int, val height: Int) {

    val maxY: Int
        get() = height / 2
    val minY: Int
        get() = if (height % 2 == 0) (-height + 1) / 2 else -height / 2
    val maxX: Int
        get() = width / 2
    val minX: Int
        get() = if (width % 2 == 0) (-width + 1) / 2 else -width / 2

    fun determineCurrentPositionOf(point: Point): Point {
        return if (point.y > maxY) {
            val gap = point.y - maxY
            val currentY = (minY + gap) - 1
            point.copy { Point.y transform { currentY } }
        } else if (point.y < minX) {
            val gap = minY - point.y
            val currentY = (maxY + gap) - 1
            point.copy { Point.y transform { currentY } }
        } else point
    }

    companion object
}
