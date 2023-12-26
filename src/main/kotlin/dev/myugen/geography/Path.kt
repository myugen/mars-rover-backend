package dev.myugen.geography

class Path private constructor(private val locations: MutableList<Location>) {
    fun add(anotherLocation: Location) {
        locations.add(anotherLocation)
    }

    fun currentLocation() = locations.last()

    companion object {
        fun startsAt(location: Location) = Path(mutableListOf(location))
    }
}
