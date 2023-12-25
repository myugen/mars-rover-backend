package dev.myugen.direction

data object East : Direction {
    override val onLeft: Direction
        get() = North

    override val onRight: Direction
        get() = South
}
