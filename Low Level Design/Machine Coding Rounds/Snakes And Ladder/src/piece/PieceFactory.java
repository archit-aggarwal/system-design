package piece;

import java.util.HashMap;
import java.util.Map;

public class PieceFactory {
    private final Map<String, Piece> pieces = new HashMap<>();

    public Piece getPiece(String color) {
        if (color == null || color.isEmpty() || pieces.containsKey(color)) return null;
        Piece piece = new Piece(color);
        pieces.put(color, piece);
        return piece;
    }
}
