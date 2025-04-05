package piece;

import board.Board;
import board.Cell;

public abstract class Piece {
    private final PieceColor color;
    private final Character symbol;

    Piece(PieceColor color, Character symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public PieceColor getPieceColor() {
        return this.color;
    }
    public Character getSymbol() {return this.symbol; }
    public abstract boolean isValidMove(Cell from, Cell to, Board board);
}
