package evaluator;

import board.Board;
import player.Piece;

public interface BoardEvaluator {
    boolean evaluate(Board board, Piece piece);
}
