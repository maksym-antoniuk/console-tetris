package ua.antoniuk.tetris.ui.controller

import ua.antoniuk.tetris.game.Game
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JPanel

class Joystick(private val game: Game) : JFrame("Console Tetris Joystick"), KeyListener {

    init {
        val p = JPanel()
        add(p)
        addKeyListener(this)
        setSize(200, 100)
        isVisible = true
    }

    override fun keyPressed(e: KeyEvent) {
        when (e.keyCode) {
            KeyEvent.VK_RIGHT -> println("right")
            KeyEvent.VK_LEFT -> println("left")
            KeyEvent.VK_UP -> println("up")
            KeyEvent.VK_DOWN -> println("down")
        }
    }

    override fun keyTyped(e: KeyEvent) {}

    override fun keyReleased(e: KeyEvent) {}

}