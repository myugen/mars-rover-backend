package dev.myugen.spatial

interface LimitFactory<T : Limit> {
    fun of(min: Int, max: Int): T
}

sealed interface Limit {
    val min: Int
    val max: Int

    data class Horizontal(override val min: Int, override val max: Int) : Limit {
        companion object : LimitFactory<Horizontal> {
            override fun of(min: Int, max: Int) = Horizontal(min, max)
        }
    }

    data class Vertical(override val min: Int, override val max: Int) : Limit {
        companion object : LimitFactory<Vertical> {
            override fun of(min: Int, max: Int) = Vertical(min, max)
        }
    }

    companion object {
        fun <T : Limit> from(size: Int, factory: LimitFactory<T>): T {
            val max = size / 2
            val min = if (size % 2 == 0) (-size + 1) / 2 else -size / 2
            return factory.of(min, max)
        }
    }
}
