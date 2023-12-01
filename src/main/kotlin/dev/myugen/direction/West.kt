package dev.myugen.direction

data object West : Direction {
    override val turnLeft: Direction
        get() = South

    override val turnRight: Direction
        get() = North
}
