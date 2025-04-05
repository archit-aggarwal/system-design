package piece;

import board.Board;
import board.Cell;

public class Pawn extends Piece {
    public Pawn(PieceColor color) {
        super(color, (color == PieceColor.WHITE) ? '♙' : '♟');
    }

    @Override
    public boolean isValidMove(Cell from, Cell to, Board board) {
        int dir = (this.getPieceColor() == PieceColor.BLACK) ? 1 : -1;
        int dx = to.getX() - from.getX();
        int dy = Math.abs(to.getY() - from.getY());
        Piece kill = to.getPiece();

        // Capture move (1 step diagonally forward)
        if (dx == dir && dy == 1 && kill != null) return true;

        // One step forward (no piece at destination)
        if (dx == dir && dy == 0 && kill == null) return true;

        // Two steps forward from initial position
        int startRow = (this.getPieceColor() == PieceColor.BLACK) ? 2 : 7;
        return dx == 2 * dir && dy == 0 && from.getX() == startRow &&
                board.getPiece(from.getX() + dir, from.getY()) == null && kill == null;
    }
}
