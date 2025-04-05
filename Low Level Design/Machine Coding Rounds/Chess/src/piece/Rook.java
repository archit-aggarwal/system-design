package piece;

import board.Board;
import board.Cell;

public class Rook extends Piece {
    public Rook(PieceColor color) {
        super(color, (color == PieceColor.WHITE) ? '♖' : '♜');
    }

    @Override
    public boolean isValidMove(Cell from, Cell to, Board board) {
        if(from.getX() != to.getX() && from.getY() != to.getY()) return false;

        int dx = Integer.compare(to.getX(), from.getX());
        int dy = Integer.compare(to.getY(), from.getY());

        for(int row = from.getX() + dx, col = from.getY() + dy;
                row != to.getX() || col != to.getY(); row += dx, col += dy) {
            if(board.getPiece(row, col) != null) return false;
        }

        return true;
    }
}
