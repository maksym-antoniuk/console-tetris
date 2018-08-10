package ua.antoniuk.tetris.game.figures

import ua.antoniuk.tetris.game.Color
import ua.antoniuk.tetris.util.CycledList

data class Position(val x: Int, val y: Int)

data class Block(var position: Position, val color: Color)

abstract class Figure {

    val blocks = mutableListOf<Block>()
    protected val transformers = mapOf<Transformers, CycledList<(Figure) -> Unit>>(
            Transformers.MOVE_LEFT to CycledList(listOf({ figure -> figure.blocks.forEach { it.position = Position(it.position.x - 1, it.position.y) } })),
            Transformers.MOVE_RIGHT to CycledList(listOf({ figure -> figure.blocks.forEach { it.position = Position(it.position.x + 1, it.position.y) } })),
            Transformers.MOVE_DOWN to CycledList(listOf({ figure -> figure.blocks.forEach { it.position = Position(it.position.x, it.position.y + 1) } })),
            Transformers.ROTATE to CycledList()
    )

    fun snapshotIfTransform(transformer: Transformers): Figure {
        val snapshot = duplicate()
        transformers[transformer]?.next()?.invoke(snapshot)
        return snapshot
    }

    fun transform(transformer: Transformers) {
        transformers[transformer]?.next()?.invoke(this)
    }

    fun duplicate(): Figure {
        return object : Figure() {
            init {
                for (copied in this@Figure.blocks) blocks.add(Block(copied.position.copy(), copied.color))
            }
        }
    }
}