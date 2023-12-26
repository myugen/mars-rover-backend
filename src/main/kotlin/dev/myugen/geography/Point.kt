package dev.myugen.geography

data class Point(val x: Int, val y: Int) {
    fun applies(vector: Vector) = copy(x = x + vector.x, y = y + vector.y)
}
