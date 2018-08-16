package ua.antoniuk.tetris.ui.console

import com.importre.crayon.*
import ua.antoniuk.tetris.game.Color

class ConsoleDrawer {

    fun draw(color: Color): String {
        return when (color) {
            Color.CYAN -> "  ".bgCyan() // I
            Color.BLUE -> "  ".bgBrightBlue() // J
            Color.YELLOW -> "  ".bgYellow() // L
            Color.WHITE -> "  ".bgBrightWhite() // O
            Color.GREEN -> "  ".bgBrightGreen() // S
            Color.MAGENTA -> "  ".bgMagenta() // T
            Color.RED -> "  ".bgBrightRed() // Z
            Color.BLACK -> "  ".bgBlack() // Background
            else -> "  " // Empty
        }
    }
}