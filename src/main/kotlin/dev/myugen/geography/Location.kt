package dev.myugen.geography

import dev.myugen.direction.Direction

typealias Path = List<Location>

data class Location(val point: Point, val direction: Direction)
