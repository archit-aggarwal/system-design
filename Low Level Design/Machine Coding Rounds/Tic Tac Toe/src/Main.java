import board.BoardManager;
import java.util.InputMismatchException;
import java.util.Scanner;

// javac -d out src/*.java && java -cp out Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPlayers, boardSize;

        while(true) {
            try {
                System.out.print("Enter Total Players [>1] : ");
                totalPlayers = scanner.nextInt();
                if (totalPlayers <= 1) throw new Exception("Players Can't be < 2");

                System.out.print("Enter Board Size [>= Total Players] : ");
                boardSize = scanner.nextInt();
                if (boardSize >= totalPlayers) break;
                else throw new Exception("Board Size Can't Be Less Than Players");
            }
            catch (InputMismatchException ime) {
                System.out.println("Invalid input, please enter a valid number. Try again!");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + ", Please Try Again !");
            }
        }

        BoardManager game = new BoardManager(boardSize, totalPlayers);
        game.start();
    }
}
