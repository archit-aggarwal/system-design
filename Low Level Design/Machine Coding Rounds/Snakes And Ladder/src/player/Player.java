package player;

import piece.Piece;

public class Player {
    private final String name;
    private final Piece piece;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() { return name; }
    public Piece getPiece() { return piece; }
}
