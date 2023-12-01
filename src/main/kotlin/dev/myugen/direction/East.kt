package dev.myugen.direction

data object East : Direction {
    override val turnLeft: Direction
        get() = North

    override val turnRight: Direction
        get() = South
}
