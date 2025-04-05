package piece;

import board.Cell;

public class PieceFactory {
    public static Piece getPiece(PieceColor color, PieceType type) {
        return switch (type) {
            case PAWN -> new Pawn(color);
            case KING -> new King(color);
            case QUEEN -> new Queen(color);
            case BISHOP -> new Bishop(color);
            case ROOK -> new Rook(color);
            case KNIGHT -> new Knight(color);
        };
    }

    public static Piece getPiece(Cell initialCell) {
        int row = initialCell.getX(), col = initialCell.getY();
        if(row == 2) return getPiece(PieceColor.BLACK, PieceType.PAWN);
        if(row == 7) return getPiece(PieceColor.WHITE, PieceType.PAWN);

        if(row == 1 || row == 8) {
            PieceColor color = (row == 1) ? PieceColor.BLACK : PieceColor.WHITE;
            if(col == 1 || col == 8) return getPiece(color, PieceType.ROOK);
            if(col == 2 || col == 7) return getPiece(color, PieceType.KNIGHT);
            if(col == 3 || col == 6) return getPiece(color, PieceType.BISHOP);
            if(col == 4) return getPiece(color, PieceType.QUEEN);
            else return getPiece(color, PieceType.KING);
        }

        return null;
    }
}
