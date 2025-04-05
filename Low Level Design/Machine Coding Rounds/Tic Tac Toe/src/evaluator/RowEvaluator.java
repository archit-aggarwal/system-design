package evaluator;

import board.Board;
import player.Piece;

public class RowEvaluator implements BoardEvaluator {
    private static final RowEvaluator INSTANCE = new RowEvaluator();
    private RowEvaluator() {}
    public static RowEvaluator getInstance() { return INSTANCE; }

    @Override
    public boolean evaluate(Board board, Piece piece) {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            boolean isRowSame = true;
            for (int col = 0; col < size; col++) {
                if (!board.isSame(row, col, piece)) {
                    isRowSame = false;
                    break;
                }
            }
            if (isRowSame) return true;
        }
        return false;
    }
}
