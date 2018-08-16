package ua.antoniuk.tetris.ui.controller

import ua.antoniuk.tetris.game.GameEngine
import ua.antoniuk.tetris.game.figures.Transformers
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JPanel
import kotlin.concurrent.thread

class Joystick(private val gameEngine: GameEngine) : JFrame("Console Tetris Joystick"), KeyListener {

    init {
        val p = JPanel()
        add(p)
        addKeyListener(this)
        setSize(200, 100)
        isVisible = true
        thread(start = true) {
            while (true) {
                gameEngine.transform(Transformers.MOVE_DOWN)
                if (gameEngine.isGameOver()) {
                    break
                }
                Thread.sleep(1000)
            }
        }
    }

    override fun keyPressed(e: KeyEvent) {
        when (e.keyCode) {
            KeyEvent.VK_RIGHT -> gameEngine.transform(Transformers.MOVE_RIGHT)
            KeyEvent.VK_LEFT -> gameEngine.transform(Transformers.MOVE_LEFT)
            KeyEvent.VK_UP -> gameEngine.transform(Transformers.ROTATE)
            KeyEvent.VK_DOWN -> gameEngine.transform(Transformers.MOVE_DOWN)
        }
    }

    override fun keyTyped(e: KeyEvent) {}

    override fun keyReleased(e: KeyEvent) {}

}