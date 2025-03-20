package player;

import move.BotMoveStrategy;
import piece.Piece;

public class BotPlayer extends Player {
    public BotPlayer(String name, Piece piece) {
        super(name, piece, BotMoveStrategy.getInstance());
    }
}
