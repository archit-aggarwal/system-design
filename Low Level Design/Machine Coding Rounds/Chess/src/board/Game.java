package board;

import piece.PieceColor;
import player.Move;
import player.Player;

public class Game {
    private final Player whitePlayer, blackPlayer;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
    }

    public void start() {
        System.out.println("Chess Game Starts !!!");
        Board board = new Board();
        PieceColor turn = PieceColor.WHITE;

        while(true) {
            board.displayBoard();

            Player player  = (turn == PieceColor.WHITE) ? whitePlayer : blackPlayer;
            System.out.println("Player " + player.getName() + "'s turn with " + turn + " pieces.");

            Move move = player.getMove(board, turn);
            GameState gameState = board.movePiece(move);

            if(gameState != GameState.NO_RESULT) {
                System.out.println("Game State : " + gameState.name());
                return;
            }

            turn = (turn == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
        }
    }
}
