package player;

import piece.Piece;
import piece.PieceFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class PlayerFactory {
    private enum PlayerType { HUMAN, BOT }
    private final Scanner scanner = new Scanner(System.in);
    private final Map<PlayerType, BiFunction<String, Piece, Player>> playerMap = new HashMap<>();
    private final PieceFactory pieceFactory;

    public PlayerFactory() {
        playerMap.put(PlayerType.HUMAN, HumanPlayer::new);
        playerMap.put(PlayerType.BOT, BotPlayer::new);
        this.pieceFactory = new PieceFactory();
    }

    public Player getPlayer(int playerCount) {
        System.out.print("Enter Player " + playerCount + " Name : ");
        String playerName = scanner.next();

        while (true) {
            System.out.print("Enter Piece Type [Human or Bot] : ");
            String type = (scanner.next()).toUpperCase();

            try {
                PlayerType playerType = PlayerType.valueOf(type);
                return playerMap.get(playerType).apply(playerName, pieceFactory.getPiece());
            }
            catch (Exception e) {
                System.out.println("Invalid Player Type. Enter Again!");
            }
        }
    }
}
