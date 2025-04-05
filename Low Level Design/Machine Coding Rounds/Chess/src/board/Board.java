package board;

import piece.*;
import player.Move;

public class Board {
    public final int BOARD_SIZE = 8, MAX_MOVES_ALLOWED = 50;
    private final Cell[][] cells = new Cell[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        for(int row = 1; row <= BOARD_SIZE; row++) {
            for(int col = 1; col <= BOARD_SIZE; col++) {
                Cell cell = new Cell(row, col);
                cells[row - 1][col - 1] = cell;
                cell.setPiece(PieceFactory.getPiece(cell));
            }
        }
    }

    public Cell getCell(int row, int col) {
        if(row < 1 || col < 1 || col > BOARD_SIZE || row > BOARD_SIZE) return null;
        return cells[row - 1][col - 1];
    }

    public Piece getPiece(int row, int col) {
        Cell cell = getCell(row, col);
        if(cell == null) return null;
        return cell.getPiece();
    }

    public GameState movePiece(Move move) {
        Cell from = move.getFrom();
        Cell to = move.getTo();

        Piece piece = from.getPiece();
        from.setPiece(null);

        if((piece instanceof Pawn) || (to.getPiece() != null))
            Move.moveCount = 0;
        else if(Move.moveCount++ > MAX_MOVES_ALLOWED)
            return GameState.DRAW;

        GameState gameState = GameState.NO_RESULT;
        if(to.getPiece() != null && to.getPiece() instanceof King) {
            if(piece.getPieceColor() == PieceColor.WHITE)
                gameState = GameState.WHITE_WON;
            else gameState = GameState.BLACK_WON;
        }

        to.setPiece(piece);
        return gameState;
    }

    public void displayBoard() {
        for(int row = 1; row <= BOARD_SIZE; row++) {
            for(int col = 1; col <= BOARD_SIZE; col++) {
                System.out.print(cells[row - 1][col - 1] + " ");
            }
            System.out.println();
            for(int col = 1; col <= BOARD_SIZE; col++) {
                System.out.print("———");
            }
            System.out.println();
        }
    }
}
