package dev.myugen.spatial

internal val Planet.Companion.fixture: PlanetFixture
    get() = PlanetFixture

internal object PlanetFixture {
    /**
     * No-sized planet with 0 width and 0 height
     */
    val noSize = Planet(0, 0)
}
