package element;

public class Snake extends Element {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public int useElement() {
        System.out.println("Bitten by snake, dropping to [" + super.getEnd() + "]");
        return super.getEnd();
    }
}
