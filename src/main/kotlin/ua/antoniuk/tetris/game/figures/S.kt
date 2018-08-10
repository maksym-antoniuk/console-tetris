package ua.antoniuk.tetris.game.figures

import ua.antoniuk.tetris.game.Color

class S : Figure() {

    init {
        blocks.addAll(listOf(
                Block(Position(4, 3), Color.GREEN),
                Block(Position(5, 3), Color.GREEN),
                Block(Position(5, 2), Color.GREEN),
                Block(Position(6, 2), Color.GREEN)
        ))
        transformers[Transformers.ROTATE]?.addAll(listOf(
                /**
                 * 0 0 0     1 0 0
                 * 0 3 4 ==> 2 3 0
                 * 1 2 0     0 4 0
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x, block.position.y - 2)
                    block = figure.blocks[1]
                    block.position = Position(block.position.x - 1, block.position.y - 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x - 1, block.position.y + 1)
                },
                /**
                 * 1 0 0     0 2 1
                 * 2 3 0 ==> 4 3 0
                 * 0 4 0     0 0 0
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x + 2, block.position.y)
                    block = figure.blocks[1]
                    block.position = Position(block.position.x + 1, block.position.y - 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x - 1, block.position.y - 1)
                },
                /**
                 * 0 2 1     0 4 0
                 * 4 3 0 ==> 0 3 2
                 * 0 0 0     0 0 1
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x, block.position.y + 2)
                    block = figure.blocks[1]
                    block.position = Position(block.position.x + 1, block.position.y + 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x + 1, block.position.y - 1)
                },
                /**
                 * 0 4 0     0 0 0
                 * 0 3 2 ==> 0 3 4
                 * 0 0 1     1 2 0
                 */
                { figure ->
                    var block = figure.blocks[0]
                    block.position = Position(block.position.x - 2, block.position.y)
                    block = figure.blocks[1]
                    block.position = Position(block.position.x - 1, block.position.y + 1)
                    block = figure.blocks[3]
                    block.position = Position(block.position.x + 1, block.position.y + 1)
                }
        ))
    }
}