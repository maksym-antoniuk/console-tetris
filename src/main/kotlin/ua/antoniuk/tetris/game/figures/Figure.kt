package ua.antoniuk.tetris.game.figures

import ua.antoniuk.tetris.game.Color
import ua.antoniuk.tetris.util.CycledList

data class Position(val x: Int, val y: Int)

data class Block(var position: Position, val color: Color)

abstract class Figure {

    val blocks = mutableListOf<Block>()
    protected val spinners = CycledList<(Figure) -> Unit>()

    fun snapshotIfMoveRight(): Figure {
        val snapshot = duplicate()
        snapshot.moveRight()
        return snapshot
    }

    fun moveRight() {
        blocks.forEach { it.position = Position(it.position.x + 1, it.position.y) }
    }

    fun snapshotIfMoveLeft(): Figure {
        val snapshot = duplicate()
        snapshot.moveLeft()
        return snapshot
    }

    fun moveLeft() {
        blocks.forEach { it.position = Position(it.position.x - 1, it.position.y) }
    }

    fun snapshotIfMoveDown(): Figure {
        val snapshot = duplicate()
        snapshot.moveDown()
        return snapshot
    }

    fun moveDown() {
        blocks.forEach { it.position = Position(it.position.x, it.position.y + 1) }
    }

    fun snapshotIfRotate(): Figure {
        val snapshot = duplicate()
        snapshot.rotate()
        return snapshot
    }

    fun rotate() {
        spinners.next().invoke(this)
    }

    fun duplicate(): Figure {
        return object : Figure() {
            init {
                for (copied in this@Figure.blocks) blocks.add(Block(copied.position.copy(), copied.color))
            }
        }
    }
}