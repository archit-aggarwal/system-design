package player;

import java.util.Objects;

public class Piece {
    private final Character pieceType;

    public Piece(Character pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Piece other)) return false;
        return Objects.equals(this.pieceType, other.pieceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType);
    }

    @Override
    public String toString() { return pieceType.toString(); }
}
