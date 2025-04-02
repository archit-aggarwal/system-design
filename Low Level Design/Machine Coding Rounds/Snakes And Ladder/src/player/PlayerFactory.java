package player;

import piece.Piece;
import piece.PieceFactory;

public class PlayerFactory {
    private final PieceFactory pieceFactory = new PieceFactory();

    public Player getPlayer(String name, String color) {
        Piece piece = pieceFactory.getPiece(color);
        if(piece == null || name == null || name.isEmpty()) return null;
        return new Player(name, piece);
    }
}
