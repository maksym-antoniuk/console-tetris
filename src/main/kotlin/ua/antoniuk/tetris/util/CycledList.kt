package ua.antoniuk.tetris.util

class CycledList<E> {

    private val cycledList = mutableListOf<E>()
    private var index = 0

    fun addAll(elements: Collection<E>) {
        cycledList.addAll(elements)
    }

    fun next(): E {
        if(cycledList.isEmpty()) throw NoSuchElementException("Cycled list has no elements")
        if(index == cycledList.size - 1) index = 0
        return cycledList[index++]
    }
}