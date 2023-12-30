package dev.myugen.common

interface Initializer<T, R : Builder<T>> {
    fun fixture(init: R.() -> Unit): T
}
