package ua.antoniuk.tetris.ui.console

import com.importre.crayon.bgBrightWhite
import ua.antoniuk.tetris.glass.Glass
import ua.antoniuk.tetris.ui.Renderer


class ConsoleRender : Renderer {

    private val drawer = ConsoleDrawer()

    override fun render(glass: Glass) {
        // clear
        println("\u001Bc")
        for (row in glass.table) {
            print(" ".bgBrightWhite())
            for (cell in row) {
                print(drawer.draw(cell))
            }
            println(" ".bgBrightWhite())
        }
        print(" ".bgBrightWhite())
        for (i in 0..9) print("  ".bgBrightWhite())
        println(" ".bgBrightWhite())
    }
}