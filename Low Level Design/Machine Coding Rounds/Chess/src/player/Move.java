package player;

import board.Board;
import board.Cell;
import piece.Piece;
import piece.PieceColor;

public class Move {
    public static int moveCount = 0;
    private final Cell from, to;
    private final PieceColor color;

    public Move(Cell from, Cell to, PieceColor color) {
        this.from = from;
        this.to = to;
        this.color = color;
    }

    public Cell getFrom() { return from; }
    public Cell getTo() { return to; }

    public boolean isValid(Board board) {
        if (from == null || to == null || from == to) return false;

        Piece piece = from.getPiece();
        if (piece == null || piece.getPieceColor() != color) return false;

        Piece kill = to.getPiece();
        if (kill != null && kill.getPieceColor() == color) return false;

        return piece.isValidMove(from, to, board);
    }
}
