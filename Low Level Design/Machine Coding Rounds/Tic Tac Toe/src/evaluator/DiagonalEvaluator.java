package evaluator;

import board.Board;
import player.Piece;

public class DiagonalEvaluator implements BoardEvaluator {
    private static final DiagonalEvaluator INSTANCE = new DiagonalEvaluator();
    private DiagonalEvaluator() {}
    public static DiagonalEvaluator getInstance() { return INSTANCE; }

    @Override
    public boolean evaluate(Board board, Piece piece) {
        int size = board.getSize();
        boolean primaryDiagonal = true, secondaryDiagonal = true;

        for (int i = 0; i < size; i++) {
            if (!board.isSame(i, i, piece)) primaryDiagonal = false;
            if (!board.isSame(i, size - 1 - i, piece)) secondaryDiagonal = false;
        }
        return primaryDiagonal || secondaryDiagonal;
    }
}
