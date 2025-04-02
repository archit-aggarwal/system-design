package board;

import player.Player;
import player.PlayerState;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game extends Thread {
    private final int gameId;
    private final Board board;
    private final Queue<Player> playerQueue = new LinkedList<>();
    private final String gameColor;

    public Game(int gameId, Board board, List<Player> players) {
        this.gameId = gameId;
        this.board = board;
        this.gameColor = this.generateColor(gameId);
        playerQueue.addAll(players);
    }

    private String generateColor(int id) {
        int r = (id * 50) % 256;
        int g = (id * 100) % 256;
        int b = (id * 150) % 256;
        return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }

    @Override
    public void run() {
        System.out.println(gameColor + "Game [" + gameId + "] starts...");

        while (true) {
            Player turn = playerQueue.remove();
            System.out.println(gameColor + "Turn of Player [" + turn.getName() + "] with Piece [" + turn.getPiece() + "]");

            PlayerState state = board.makeMove(turn.getPiece(), gameColor);
            if (state == PlayerState.WIN) {
                System.out.println(gameColor + "Player " + turn.getName() + " Wins in Game [" + gameId + "]");
                return;
            }
            else if(state == PlayerState.LOSE) {
                System.out.println(gameColor + "Player " + turn.getName() + " Loses in Game [" + gameId + "]");
                if(playerQueue.isEmpty()) System.out.println(gameColor + " Ends in a Draw !");
            }
            else playerQueue.add(turn);
        }
    }
}