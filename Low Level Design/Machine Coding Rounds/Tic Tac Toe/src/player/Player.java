package player;

import board.Board;
import board.BoardState;
import move.Move;
import move.MoveStrategy;

public abstract class Player {
    private final String name;
    private final Piece piece;
    private final MoveStrategy moveStrategy;

    public Player(String name, Piece piece, MoveStrategy moveStrategy) {
        this.name = name;
        this.piece = piece;
        this.moveStrategy = moveStrategy;
    }

    public String getName() { return name; }
    public Piece getPiece() { return piece; }

    public BoardState makeMove(Board board) {
        Move move = moveStrategy.getMove(board);
        board.setPiece(move, piece);
        return board.getState(piece);
    }
}
