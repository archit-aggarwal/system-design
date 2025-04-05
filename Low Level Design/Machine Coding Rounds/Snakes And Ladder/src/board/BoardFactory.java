package board;

import element.Element;
import element.Ladder;
import element.Snake;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardFactory {
    private static final BoardFactory INSTANCE = new BoardFactory();
    private BoardFactory() {}
    public static BoardFactory getInstance() { return INSTANCE; }
    private final Scanner scanner = new Scanner(System.in);

    public Board getBoard() {
        System.out.println("Enter Board Size Details: ");
        int boardSize = getInteger("Board Size Should be > 0", value -> value > 0);

        System.out.println("Enter Number of Dices to Use: ");
        Validator rangeValidator = value -> value > 0 && value <= boardSize;
        String rangeError = "Value should be in range [1," + boardSize + "]";
        int countOfDices = getInteger(rangeError, rangeValidator);

        System.out.println("Enter Count of Snakes & Ladders: ");
        int countOfElements = getInteger("Count should be >= 0", value -> value >= 0);

        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < countOfElements; i++) {
            System.out.println("Enter Start & End Position for Snake/Ladder: ");
            int start = getInteger(rangeError, rangeValidator);
            int end = getInteger(rangeError, rangeValidator);

            if (start < end) elements.add(new Ladder(start, end));
            else if (start > end) elements.add(new Snake(start, end));
            else System.out.println("Start and End cannot be the same. Skipping this element.");
        }

        return new Board(boardSize, elements, new Dice(countOfDices));
    }

    private int getInteger(String errorMessage, Validator validator) {
        while (true) {
            int value;
            try { value = Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
                continue;
            }

            if (validator.isValid(value)) return value;
            else System.out.println("Error: " + errorMessage);
        }
    }

    private interface Validator { boolean isValid(int value); }
}
