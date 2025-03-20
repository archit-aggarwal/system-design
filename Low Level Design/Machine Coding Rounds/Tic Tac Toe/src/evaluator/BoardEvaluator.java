package evaluator;

import board.Board;
import piece.Piece;

public interface BoardEvaluator {
    boolean evaluate(Board board, Piece piece);
}
