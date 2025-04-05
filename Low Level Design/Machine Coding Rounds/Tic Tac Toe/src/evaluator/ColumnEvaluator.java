package evaluator;

import board.Board;
import player.Piece;

public class ColumnEvaluator implements BoardEvaluator {
    private static final ColumnEvaluator INSTANCE = new ColumnEvaluator();
    private ColumnEvaluator() {}
    public static ColumnEvaluator getInstance() { return INSTANCE; }

    @Override
    public boolean evaluate(Board board, Piece piece) {
        int size = board.getSize();
        for (int col = 0; col < size; col++) {
            boolean isColSame = true;
            for (int row = 0; row < size; row++) {
                if (!board.isSame(row, col, piece)) {
                    isColSame = false;
                    break;
                }
            }
            if (isColSame) return true;
        }
        return false;
    }
}
