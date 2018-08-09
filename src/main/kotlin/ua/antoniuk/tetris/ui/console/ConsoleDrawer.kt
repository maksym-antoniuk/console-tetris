package ua.antoniuk.tetris.ui.console

import com.importre.crayon.*

class ConsoleDrawer {

    fun draw(cell: Int): String {
        return when (cell) {
            1 -> "  ".bgCyan() // I
            2 -> "  ".bgBrightBlue() // J
            3 -> "  ".bgYellow() // L
            4 -> "  ".bgBrightWhite() // O
            5 -> "  ".bgBrightGreen() // S
            6 -> "  ".bgMagenta() // T
            7 -> "  ".bgBrightRed() // Z
            else -> "  ".bgBlack() // Empty
        }
    }
}