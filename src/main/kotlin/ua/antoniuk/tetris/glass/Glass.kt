package ua.antoniuk.tetris.glass

import ua.antoniuk.tetris.game.figures.Figure
import ua.antoniuk.tetris.game.figures.FigureGenerator

class Glass {

    var table = MutableList(24) {IntArray(10)}
    val figures = mutableListOf<Figure>()
    lateinit var activeFigure: Figure
    lateinit var nextFigure: Figure



}