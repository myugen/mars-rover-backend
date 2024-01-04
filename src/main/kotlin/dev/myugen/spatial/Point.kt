package dev.myugen.spatial

import arrow.optics.copy
import arrow.optics.optics

@optics
data class Point(val x: Int, val y: Int) {
    companion object

    fun applies(vector: Vector) = copy {
        Point.x transform { it + vector.x }
        Point.y transform { it + vector.y }
    }
}
