package evaluator;

import board.Board;
import piece.Piece;

public class DrawEvaluator implements BoardEvaluator {
    private static final DrawEvaluator INSTANCE = new DrawEvaluator();
    private DrawEvaluator() {}
    public static DrawEvaluator getInstance() { return INSTANCE; }

    @Override
    public boolean evaluate(Board board, Piece piece) {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.isSame(row, col, null)) {
                    return false;
                }
            }
        }
        return true;
    }
}
