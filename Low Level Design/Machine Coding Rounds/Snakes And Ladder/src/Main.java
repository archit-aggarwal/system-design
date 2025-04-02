import board.Board;
import board.Game;
import dice.Dice;
import element.Element;
import element.Ladder;
import element.Snake;
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

            System.out.println("Enter Board Size Details for Game [" + gameId + "] : ");
            int boardSize = scn.nextInt();
            if(boardSize <= 0) continue;

            System.out.println("Enter Number of Dices to Use : ");
            int countOfDices = scn.nextInt();
            if(countOfDices <= 0 || countOfDices > boardSize) continue;

            List<Element> elements = new ArrayList<>();
            System.out.println("Enter Count of Snakes & Ladders : ");
            int countOfElements = scn.nextInt();

            while(countOfElements-- > 0) {
                System.out.println("Enter Start & End Position for Snake/Ladder : ");
                int start = scn.nextInt();
                int end = scn.nextInt();

                if(start < end) elements.add(new Ladder(start, end));
                else if(end < start) elements.add(new Snake(start, end));
            }

            System.out.println("Enter Number of Players : ");
            int countOfPlayers = scn.nextInt();
            List<Player> players = new ArrayList<>();

            while(countOfPlayers-- > 0) {
                System.out.println("Enter Player Name & Piece Color : ");
                String name = scn.next();
                String color = scn.next();

                Player player = playerFactory.getPlayer(name, color);
                if(player != null) players.add(player);
            }

            if(players.size() <= 1) continue;
            Board board = new Board(boardSize, elements, new Dice(countOfDices));
            games.add(new Game(gameId, board, players));
        }

        games.forEach(Thread::start);
    }
}