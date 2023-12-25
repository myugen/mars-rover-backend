package dev.myugen.direction

data object South : Direction {
    override val onLeft: Direction
        get() = East

    override val onRight: Direction
        get() = West
}
