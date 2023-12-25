package dev.myugen.direction

data object West : Direction {
    override val onLeft: Direction
        get() = South

    override val onRight: Direction
        get() = North
}
