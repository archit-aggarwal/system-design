package move;

import board.Board;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy {
    private final Scanner scanner = new Scanner(System.in);

    private static final MoveStrategy singleton = new HumanMoveStrategy();
    private HumanMoveStrategy() {}
    public static MoveStrategy getInstance() { return singleton; }

    @Override
    public Move getMove(Board board) {
        Move move = new Move();

        while(true) {
            try {
                System.out.print("Move Row : ");
                move.setRow(scanner.nextInt());

                System.out.print("Move Col : ");
                move.setCol(scanner.nextInt());

                if(board.isEmpty(move)) return move;
                System.out.println("Choose a valid move");
            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid input, please enter a valid number. Try again!");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            }
            catch (Exception e) {
                System.out.println("Choose a valid move");
            }
        }
    }
}
