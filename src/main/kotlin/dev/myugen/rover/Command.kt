package dev.myugen.rover

import dev.myugen.geography.Location
import dev.myugen.geography.Path

data class Command(private val value: String) {
    fun calculatePathOver(currentLocation: Location): Path {
        TODO("Not yet implemented")
    }
}