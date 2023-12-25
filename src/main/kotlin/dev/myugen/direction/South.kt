package dev.myugen.direction

data object South : Direction {
    override val turnLeft: Direction
        get() = East

    override val turnRight: Direction
        get() = West
}
