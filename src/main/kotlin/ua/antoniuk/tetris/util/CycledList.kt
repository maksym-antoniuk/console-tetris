package ua.antoniuk.tetris.util

class CycledList<E>() {

    private val cycledList = mutableListOf<E>()
    var index = 0
        set(value) {field = if (value >= cycledList.size) 0 else value}

    constructor(elements: Collection<E>): this() {
        cycledList.addAll(elements)
    }

    fun addAll(elements: Collection<E>) {
        cycledList.addAll(elements)
    }

    fun next(): E {
        if(cycledList.isEmpty()) throw NoSuchElementException("Cycled list has no elements")
        if(index == cycledList.size) index = 0
        return cycledList[index++]
    }

    fun asList(): List<E> {
        return cycledList
    }

    fun clear() {
        cycledList.clear()
        index = 0
    }
}