package dev.myugen.spatial

import arrow.optics.optics

@optics
data class Planet(val width: Int, val height: Int) {

    val verticalLimit: Limit.Vertical
        get() = Limit.from(height, Limit.Vertical)
    val horizontalLimit: Limit.Horizontal
        get() = Limit.from(width, Limit.Horizontal)

    fun normalize(point: Point): Point =
        point.normalizesBy(listOf(verticalLimit, horizontalLimit))

    companion object
}
