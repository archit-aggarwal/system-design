package player;

import piece.Piece;
import piece.PieceFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerFactory {
    private final PieceFactory pieceFactory = new PieceFactory();
    private final Scanner scanner = new Scanner(System.in);

    private Player getPlayer(String name, String color) {
        Piece piece = pieceFactory.getPiece(color);
        if(piece == null || name == null || name.isEmpty()) return null;
        return new Player(name, piece);
    }

    public List<Player> getPlayers() {
        System.out.print("Enter Number of Players: ");
        int countOfPlayers;
        while (true) {
            try {
                countOfPlayers = Integer.parseInt(scanner.nextLine().trim());
                if (countOfPlayers > 1) break;
                System.out.println("Error: Count should be > 1");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }

        List<Player> players = new ArrayList<>();
        while (players.size() < countOfPlayers) {
            try {
                System.out.println("Enter Player Name & Piece Color: ");
                String name = scanner.next();
                String color = scanner.next();

                Player player = this.getPlayer(name, color);
                if (player == null) throw new RuntimeException("Invalid Player");
                players.add(player);
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage() + ", Try Again!");
                scanner.nextLine();
            }
        }

        return players;
    }
}
