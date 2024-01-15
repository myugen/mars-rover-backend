package dev.myugen.spatial

import arrow.optics.copy
import arrow.optics.optics
import kotlin.math.absoluteValue

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
        return when {
            (point.y > maxY) -> {
                point.copy { Point.y transform { normalizeExceededAxis(point.y, maxY, minY) } }
            }

            (point.y < minY) -> {
                point.copy { Point.y transform { normalizeExceededAxis(point.y, minY, maxY) } }
            }

            (point.x > maxX) -> {
                point.copy { Point.x transform { normalizeExceededAxis(point.x, maxX, minX) } }
            }

            (point.x < minX) -> {
                point.copy { Point.x transform { normalizeExceededAxis(point.x, minX, maxX) } }
            }

            else -> point
        }
    }

    private fun normalizeExceededAxis(exceededAxis: Int, limitAxis: Int, correctAxis: Int): Int {
        val gap = exceededAxis.absoluteValue - limitAxis.absoluteValue
        return correctAxis + gap - 1
    }

    companion object
}
