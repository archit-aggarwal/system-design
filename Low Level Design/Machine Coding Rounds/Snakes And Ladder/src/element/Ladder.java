package element;

public class Ladder extends Element {
    public Ladder(int start, int end) { super(start, end); }

    @Override
    public int useElement() {
        System.out.println("Takes Ladder and Climbs to [" + super.getEnd() + "]");
        return super.getEnd();
    }
}
