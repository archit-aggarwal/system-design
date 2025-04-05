package piece;

import board.Board;
import board.Cell;

public class Bishop extends Piece {
    public Bishop(PieceColor color) {
        super(color, (color == PieceColor.WHITE) ? '♗' : '♝');
    }

    @Override
    public boolean isValidMove(Cell from, Cell to, Board board) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();
        if (Math.abs(dx) != Math.abs(dy)) return false;

        dx = (dx > 0) ? 1 : -1;
        dy = (dy > 0) ? 1 : -1;

        for (int row = from.getX() + dx, col = from.getY() + dy; row != to.getX(); row += dx, col += dy) {
            if (board.getPiece(row, col) != null) return false;
        }

        return true;
    }
}
