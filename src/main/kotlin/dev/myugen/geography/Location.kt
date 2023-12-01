package dev.myugen.geography

import dev.myugen.direction.Direction

typealias Path = List<Location>

data class Location(private val point: Point, private val direction: Direction)
