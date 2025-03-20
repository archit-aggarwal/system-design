package move;

import board.Board;
import java.util.Random;

public class BotMoveStrategy implements MoveStrategy {
    private final Random random = new Random();

    private static final MoveStrategy singleton = new BotMoveStrategy();
    private BotMoveStrategy() {}
    public static MoveStrategy getInstance() { return singleton; }

    @Override
    public Move getMove(Board board) {
        Move move = new Move();

        do {
            move.setRow(random.nextInt(board.getSize()));
            move.setCol(random.nextInt(board.getSize()));
        } while (!board.isEmpty(move));

        return move;
    }
}
