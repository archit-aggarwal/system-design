package board;

import dice.Dice;
import element.Element;
import piece.Piece;
import player.Player;
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

    public boolean makeMove(Player player, String gameColor) {
        Piece piece = player.getPiece();
        int diceRoll = dice.rollDice();
        System.out.println(gameColor + "Rolling Dice(s) : Total = " + diceRoll);
        int destination = piece.getPosition() + diceRoll;

        if (destination > size) {
            System.out.println(gameColor + "Player [" + player.getName() + "] can't move to [" + destination + "] cell as it is out of board");
            return false;
        }

        if (elements.containsKey(destination))
            piece.setPosition(elements.get(destination).useElement(player));
        else {
            System.out.println(gameColor + "Player [" + player.getName() + "] moved to [" + destination + "] cell");
            piece.setPosition(destination);
        }

        return (piece.getPosition() == size);
    }
}
