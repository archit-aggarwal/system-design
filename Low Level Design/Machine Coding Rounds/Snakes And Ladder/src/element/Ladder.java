package element;

import player.Player;

public class Ladder extends Element {
    public Ladder(int start, int end) { super(start, end); }

    @Override
    public int useElement(Player player) {
        System.out.println("Player [" + player.getName() + "] climbs ladder to [" + super.getEnd() + "]");
        return super.getEnd();
    }
}
