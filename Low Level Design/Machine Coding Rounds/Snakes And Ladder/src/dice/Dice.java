package dice;

import java.util.Random;

public class Dice {
    private final int countOfDices;
    private final Random random = new Random();

    public Dice(int countOfDices) {
        this.countOfDices = countOfDices;
    }

    public int rollDice() {
        int total = 0;
        for(int dice = 1; dice <= countOfDices; dice++) {
            int value = random.nextInt(7);
            total += value;
        }

        return total;
    }
}
