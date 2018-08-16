package ua.antoniuk.tetris.game.figures

import ua.antoniuk.tetris.random

class FigureGenerator {

    fun randomFigure(): Figure {
        return when ((1..7).random()) {
            1 -> I()
            2 -> J()
            3 -> L()
            4 -> O()
            5 -> S()
            6 -> T()
            7 -> Z()
            else -> throw IllegalStateException("Its impossible")
        }
    }
}