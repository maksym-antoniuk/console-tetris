package ua.antoniuk.tetris.game

import ua.antoniuk.tetris.game.figures.Figure
import ua.antoniuk.tetris.game.figures.FigureGenerator
import ua.antoniuk.tetris.game.figures.Position
import ua.antoniuk.tetris.game.figures.Transformers
import ua.antoniuk.tetris.glass.Glass
import ua.antoniuk.tetris.ui.console.ConsoleRender

class GameEngine(private val glass: Glass) {

    private val render = ConsoleRender()
    private val figureGenerator = FigureGenerator()
    private var isPlay = false

    fun transform(transformer: Transformers) {
        synchronized(glass) {
            if (isPlay) {
                val nextFrame = glass.activeFigure.snapshotIfTransform(transformer)
                if (canMoveAside(nextFrame) && canMoveDown(nextFrame)) {
                    glass.activeFigure.transform(transformer)
                } else if (!canMoveDown(nextFrame) && !canMoveDown(glass.activeFigure.snapshotIfTransform(Transformers.MOVE_DOWN))) {
                    glass.figures.add(glass.activeFigure)
                    glass.activeFigure.blocks.forEach { glass.table[it.position.y][it.position.x] = 1 }
                    deleteRows()
                    if (isGameOver()) {
                        stop()
                        return
                    } else {
                        glass.activeFigure = glass.nextFigure
                        glass.nextFigure = figureGenerator.randomFigure()
                    }
                }
                render.render(glass)
            }
        }
    }

    fun start() {
        glass.activeFigure = figureGenerator.randomFigure()
        glass.nextFigure = figureGenerator.randomFigure()
        isPlay = true
    }

    fun stop() {
        isPlay = false
        render.render(glass)
        println("GAME OVER")
    }

    private fun canMoveAside(figure: Figure): Boolean {
        return figure.blocks.all { activeBlock ->
            activeBlock.position.x in 0..9 && glass.figures.all { staticFigure ->
                staticFigure.blocks.all { block ->
                     !(block.position.y == activeBlock.position.y && block.position.x == activeBlock.position.x)
                }
            }
        }
    }

    private fun canMoveDown(figure: Figure): Boolean {
        return figure.blocks.all{ activeBlock ->
            activeBlock.position.y < glass.table.size && glass.figures.all { staticFigure ->
                staticFigure.blocks.all { block ->
                    activeBlock.position.y < glass.table.size &&
                            !(block.position.y == activeBlock.position.y && block.position.x == activeBlock.position.x)
                }
            }
        }
    }

    private fun deleteRows() {
        val indexesToRemove = mutableSetOf<Int>()
        glass.table.forEachIndexed { rowIndex, row ->
            if(row.all { it == 1 }) row.forEachIndexed { index, _ ->
                indexesToRemove.add(rowIndex)
                row[index] = 0
                glass.figures.forEach { figure ->
                    figure.blocks.removeIf { it.position == Position(index, rowIndex) }
                }
            }
        }

        indexesToRemove.forEach { y ->
            println(glass.figures.flatMap { it.blocks }.filter { it.position.y < y })
            glass.figures.flatMap { it.blocks }.filter { it.position.y < y }.sortedBy { it.position.y }.forEach {
                it.position = Position(it.position.x, it.position.y + 1)
            }
        }

        val indexes = indexesToRemove.toList()
        for (i in 0 until indexesToRemove.size) {
            glass.table.removeAt(indexes[i])
            glass.table.add(0, IntArray(10))
        }
    }

    fun isGameOver(): Boolean {
        return glass.figures.flatMap { it.blocks }.any { it.position.y < 4 }
    }
}