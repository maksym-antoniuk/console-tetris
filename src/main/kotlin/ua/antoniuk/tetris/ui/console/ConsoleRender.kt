package ua.antoniuk.tetris.ui.console

import ua.antoniuk.tetris.game.Color
import ua.antoniuk.tetris.game.figures.Position
import ua.antoniuk.tetris.glass.Glass
import ua.antoniuk.tetris.ui.Renderer


class ConsoleRender : Renderer {

    private val drawer = ConsoleDrawer()

    override fun render(glass: Glass) {
        println("\u001Bc")
        for (i in 0..3) {
            print(drawer.draw(Color.NONE))
            for (j in 0..16) {
                if (j > 10) {
                    if (glass.nextFigure.blocks.any { it.position == Position(j - 8, i) }) {
                        print(drawer.draw(glass.nextFigure.blocks[0].color))
                    } else {
                        print(drawer.draw(Color.NONE))
                    }
                    continue
                }
                if (glass.activeFigure.blocks.any { it.position == Position(j, i) }) {
                    print(drawer.draw(glass.activeFigure.blocks[0].color))
                } else {
                    print(drawer.draw(Color.NONE))
                }
            }
            println(drawer.draw(Color.NONE))
        }

        for (x in 4..23) {
            print(drawer.draw(Color.WHITE))
            for (y in 0..9) {
                when {
                    glass.activeFigure.blocks.any { it.position == Position(y, x) } -> print(drawer.draw(glass.activeFigure.blocks[0].color))
                    glass.figures.any { it.blocks.any { it.position == Position(y, x) } } -> print(drawer.draw(glass.figures.find { it.blocks.any { it.position == Position(y, x) } }!!.blocks[0].color))
                    else -> print(drawer.draw(Color.BLACK))
                }
            }
            println(drawer.draw(Color.WHITE))
        }
        for (i in 0..10) print(drawer.draw(Color.WHITE))
        println(drawer.draw(Color.WHITE))
    }
}