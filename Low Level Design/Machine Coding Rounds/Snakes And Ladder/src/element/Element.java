package element;

public abstract class Element {
    private final int start, end;

    Element(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() { return end; }
    public int getStart() { return start; }
    public abstract int useElement();
}
