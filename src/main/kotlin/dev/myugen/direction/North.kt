package dev.myugen.direction

data object North : Direction {
    override val onLeft: Direction
        get() = West

    override val onRight: Direction
        get() = East
}
