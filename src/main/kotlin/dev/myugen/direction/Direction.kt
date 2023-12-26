package dev.myugen.direction

sealed interface Direction {
    val onLeft: Direction
    val onRight: Direction
}

data object North : Direction {
    override val onLeft: Direction
        get() = West

    override val onRight: Direction
        get() = East
}

data object East : Direction {
    override val onLeft: Direction
        get() = North

    override val onRight: Direction
        get() = South
}

data object South : Direction {
    override val onLeft: Direction
        get() = East

    override val onRight: Direction
        get() = West
}

data object West : Direction {
    override val onLeft: Direction
        get() = South

    override val onRight: Direction
        get() = North
}
