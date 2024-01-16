package dev.myugen.spatial

import arrow.optics.copy
import arrow.optics.optics
import kotlin.math.absoluteValue

@optics
data class Point(val x: Int, val y: Int) {
    companion object

    fun applies(vector: Vector) = copy {
        Point.x transform { it + vector.x }
        Point.y transform { it + vector.y }
    }

    fun normalizesBy(limits: Iterable<Limit>) = limits.fold(this) { current, limit ->
        when (limit) {
            is Limit.Horizontal -> current.copy {
                Point.x transform { normalizeCoordinateBasedOn(current.x, limit) }
            }

            is Limit.Vertical -> current.copy {
                Point.y transform { normalizeCoordinateBasedOn(current.y, limit) }
            }
        }
    }

    private fun normalizeCoordinateBasedOn(coordinate: Int, limit: Limit) = when {
        coordinate < limit.min -> {
            val gap = coordinate.absoluteValue - limit.min.absoluteValue
            limit.max + gap - 1
        }

        coordinate > limit.max -> {
            val gap = coordinate.absoluteValue - limit.max.absoluteValue
            limit.min + gap - 1
        }

        else -> coordinate
    }
}
