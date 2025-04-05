package player;

import move.HumanMoveStrategy;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, Piece piece) {
        super(name, piece, HumanMoveStrategy.getInstance());
    }
}
