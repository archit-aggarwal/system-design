package evaluator;

import board.Board;
import piece.Piece;
import java.util.List;

public class WinEvaluator implements BoardEvaluator {
    private static final WinEvaluator INSTANCE = new WinEvaluator();
    public static WinEvaluator getInstance() { return INSTANCE; }
    private final List<BoardEvaluator> evaluators;

    private WinEvaluator() {
        evaluators = List.of(
            RowEvaluator.getInstance(),
            ColumnEvaluator.getInstance(),
            DiagonalEvaluator.getInstance()
        );
    }

    @Override
    public boolean evaluate(Board board, Piece piece) {
        return evaluators.stream().anyMatch(evaluator
                -> evaluator.evaluate(board, piece));
    }
}
