package dev.myugen.geography

import dev.myugen.direction.*

data class Vector(val x: Int, val y: Int) {
    companion object {
        fun of(direction: Direction) =
            when (direction) {
                is North -> Vector(0, 1)
                is East -> Vector(1, 0)
                is South -> Vector(0, -1)
                is West -> Vector(-1, 0)
            }
    }
}
