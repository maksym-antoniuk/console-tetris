package ua.antoniuk.tetris

import ua.antoniuk.tetris.game.GameEngine
import ua.antoniuk.tetris.glass.Glass
import ua.antoniuk.tetris.ui.console.ConsoleRender
import ua.antoniuk.tetris.ui.controller.Joystick
import java.awt.Window
import java.lang.Thread.sleep
import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt((endInclusive + 1) - start) +  start

fun main(args: Array<String>) {

    /*val k = Glass()

    k.table[0][0] = 1
    k.table[1][0] = 2
    k.table[2][0] = 3
    k.table[3][0] = 4
    k.table[4][0] = 5
    k.table[5][0] = 6
    k.table[6][0] = 7

    val renderer = ConsoleRender()

    Thread {
        for (i in 0..10) {
            readLine()
            k.table[i][3] = (1..7).random()
            sleep(300)
            renderer.render(k)
        }
    }.start()

    //var topFrame = SwingUtilities.getWindowAncestor();
    val windows = Window.getWindows()
    for (window in windows)
        println(window.name + ": " + window.javaClass)
    System.console()*/
    val gameEngine = GameEngine(Glass())
    Joystick(gameEngine)
    gameEngine.start()
}
