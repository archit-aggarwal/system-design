package piece;

import board.Board;
import board.Cell;

public class Queen extends Piece {
    public Queen(PieceColor color) {
        super(color, (color == PieceColor.WHITE) ? '♕' : '♛');
    }

    @Override
    public boolean isValidMove(Cell from, Cell to, Board board) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();

        // Queen can move like rook or bishop
        if(dx != 0 && dy != 0 && Math.abs(dx) != Math.abs(dy)) return false;

        dx = Integer.compare(dx, 0);
        dy = Integer.compare(dy, 0);

        for(int row = from.getX() + dx, col = from.getY() + dy;
            row != to.getX() || col != to.getY(); row += dx, col += dy) {
            if(board.getPiece(row, col) != null) return false;
        }

        return true;
    }
}
