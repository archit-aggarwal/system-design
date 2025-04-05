package player;

import board.Board;
import board.Cell;
import piece.PieceColor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);
    public HumanPlayer(String name) { super(name); }

    public Move getMove(Board board, PieceColor color) {
        while(true) {
            try {
                System.out.println("Enter From Row, From Col, To Row, To Col : ");
                int fromRow = scanner.nextInt();
                int fromCol = scanner.nextInt();
                int toRow = scanner.nextInt();
                int toCol = scanner.nextInt();

                Cell from = board.getCell(fromRow, fromCol);
                Cell to = board.getCell(toRow, toCol);

                Move move = new Move(from, to, color);
                if(!move.isValid(board)) throw new RuntimeException("Invalid Move");
                return move;
            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid input, please enter a valid number. Try again!");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            }
            catch (RuntimeException e) {
                System.out.println("Error : " + e.getMessage() + ", Try Again !!");
            }
        }
    }
}
