package ua.antoniuk.tetris.game.figures

import ua.antoniuk.tetris.game.Color

class L: Figure() {

    init {
        blocks.addAll(listOf(
                Block(Position(4, 1), Color.YELLOW),
                Block(Position(4, 2), Color.YELLOW),
                Block(Position(4, 3), Color.YELLOW),
                Block(Position(5, 3), Color.YELLOW)
        ))
        transformers[Transformers.ROTATE]?.addAll(listOf(
                /**
                 * 0 1 0     0 0 0
                 * 0 2 0 ==> 3 2 1
                 * 0 3 4     4 0 0
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x + 1, block.position.y + 1)
                    block = figure.blocks[2]
                    block.position = Position(block.position.x - 1, block.position.y - 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x - 2, block.position.y)
                },
                /**
                 * 0 0 0     4 3 0
                 * 3 2 1 ==> 0 2 0
                 * 4 0 0     0 1 0
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x - 1, block.position.y + 1)
                    block = figure.blocks[2]
                    block.position = Position(block.position.x + 1, block.position.y - 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x, block.position.y - 2)
                },
                /**
                 * 4 3 0     0 0 4
                 * 0 2 0 ==> 1 2 3
                 * 0 1 0     0 0 0
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x - 1, block.position.y - 1)
                    block = figure.blocks[2]
                    block.position = Position(block.position.x + 1, block.position.y + 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x + 2, block.position.y)
                },
                /**
                 * 0 0 0     0 1 0
                 * 1 2 3 ==> 0 2 0
                 * 0 0 4     4 3 0
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x + 1, block.position.y - 1)
                    block = figure.blocks[2]
                    block.position = Position(block.position.x - 1, block.position.y + 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x, block.position.y + 2)
                }
        ))
    }
}