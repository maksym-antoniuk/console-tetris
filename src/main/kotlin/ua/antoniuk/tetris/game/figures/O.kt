package ua.antoniuk.tetris.game.figures

import ua.antoniuk.tetris.game.Color

class O: Figure() {

    init {
        blocks.addAll(listOf(
                Block(Position(4, 2), Color.WHITE),
                Block(Position(5, 2), Color.WHITE),
                Block(Position(4, 3), Color.WHITE),
                Block(Position(5, 3), Color.WHITE)
        ))
        transformers[Transformers.ROTATE]?.addAll(listOf({_ -> }))
    }
}