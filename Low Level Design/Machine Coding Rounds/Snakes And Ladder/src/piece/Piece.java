package piece;

public class Piece {
    private int position = 0;
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }

    private final String color;
    public Piece(String color) {
        this.color = color;
    }
    @Override public String toString() { return "Color : " + color + ", Position : " + position; }
}
