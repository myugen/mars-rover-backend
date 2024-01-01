package dev.myugen.common

interface Initializer<T, R : Builder<T>> {
    fun init(init: R.() -> Unit): T
}
