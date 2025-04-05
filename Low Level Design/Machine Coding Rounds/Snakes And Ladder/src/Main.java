import board.Board;
import board.BoardFactory;
import board.Game;
import player.Player;
import player.PlayerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Number of Games : ");
        int countOfGames = scn.nextInt();
        List<Game> games = new ArrayList<>();

        for(int gameId = 1; gameId <= countOfGames; gameId++) {
            PlayerFactory playerFactory = new PlayerFactory();
            List<Player> players = playerFactory.getPlayers();

            Board board = BoardFactory.getInstance().getBoard();
            games.add(new Game(gameId, board, players));
        }

        games.forEach(Thread::start);
    }
}