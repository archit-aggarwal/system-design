package element;

import player.Player;

public class Snake extends Element {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public int useElement(Player player) {
        System.out.println("Player [" + player.getName() + "] gets bitten by snake and drops to [" + super.getEnd() + "]");
        return super.getEnd();
    }
}
