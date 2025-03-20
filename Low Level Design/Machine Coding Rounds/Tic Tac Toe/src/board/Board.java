package board;

import evaluator.DrawEvaluator;
import evaluator.WinEvaluator;
import move.Move;
import piece.Piece;

public class Board {
    private final int size;
    private final Piece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }

    public boolean isEmpty(Move move) {
        return this.isSame(move.getRow(), move.getCol(), null);
    }

    public boolean isSame(int row, int col, Piece piece) {
        if (row < 0 || col < 0 || row >= size || col >= size) return false;
        return (board[row][col] == piece);
    }

    public void setPiece(Move move, Piece piece) {
        if (!isEmpty(move)) return;
        board[move.getRow()][move.getCol()] = piece;
    }

    public int getSize() {
        return size;
    }

    public BoardState getState(Piece piece) {
        if(WinEvaluator.getInstance().evaluate(this, piece))
            return BoardState.WIN;

        if(DrawEvaluator.getInstance().evaluate(this, piece))
            return BoardState.DRAW;

        return BoardState.NO_RESULT;
    }

    public void printBoard() {
        System.out.println("Board : ");

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col]==null) System.out.print("  |");
                else System.out.print(board[row][col] + " |");
            }

            System.out.println();
            for (int col = 0; col < size; col++) {
                System.out.print("---");
            }
            System.out.println();
        }
    }
}
