package dev.myugen.navigation

class Path private constructor(private val locations: MutableList<Location>) {
    val currentLocation: Location
        get() = locations.last()

    fun add(anotherLocation: Location) {
        locations.add(anotherLocation)
    }

    companion object {
        fun startsAt(location: Location) = Path(mutableListOf(location))
    }
}
