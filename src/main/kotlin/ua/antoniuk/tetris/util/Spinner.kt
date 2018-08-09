package ua.antoniuk.tetris.util

import ua.antoniuk.tetris.game.figures.Figure

interface Spinner {

    fun rotate(figure: Figure)
}