package board;

import dice.Dice;
import element.Element;
import piece.Piece;
import player.PlayerState;
import java.util.HashMap;
import java.util.List;

public class Board {
    private final int size;
    private final Dice dice;
    private final HashMap<Integer, Element> elements = new HashMap<>();

    public Board(int size, List<Element> elements, Dice dice) {
        this.size = size;
        this.dice = dice;

        for (Element element : elements) {
            int start = element.getStart(), end = element.getEnd();
            if (start <= 0 || end <= 0 || start >= size || end > size) continue;
            this.elements.put(start, element);
        }
    }

    public PlayerState makeMove(Piece piece, String gameColor) {
        if(piece.getPosition() + dice.getCountOfDices() > size) return PlayerState.LOSE;

        int diceRoll = dice.rollDice();
        System.out.println(gameColor + "Rolling Dice(s) : Total = " + diceRoll);
        int destination = piece.getPosition() + diceRoll;

        if (destination > size) {
            System.out.println(gameColor + "Can't move to [" + destination + "] cell");
        }
        else if (elements.containsKey(destination))
            piece.setPosition(elements.get(destination).useElement());
        else {
            System.out.println(gameColor + "Moved Piece to [" + destination + "] cell");
            piece.setPosition(destination);
        }

        return (piece.getPosition() == size) ? PlayerState.WIN : PlayerState.NO_RESULT;
    }
}
