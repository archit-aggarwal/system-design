package move;

import board.Board;

public interface MoveStrategy {
    Move getMove(Board board);
}