package dev.myugen.direction

data object North : Direction {
    override val turnLeft: Direction
        get() = West

    override val turnRight: Direction
        get() = East
}
