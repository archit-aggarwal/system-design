package board;

import piece.Piece;

public class Cell {
    private final int x, y;
    private Piece piece;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public Piece getPiece() { return piece; }
    public void setPiece(Piece piece) { this.piece = piece; }

    @Override
    public String toString() {
        return piece == null ? "| " : "|" + piece.getSymbol();
    }
}
