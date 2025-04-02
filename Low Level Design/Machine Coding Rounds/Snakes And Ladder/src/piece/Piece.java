package piece;

import java.util.Objects;

public class Piece {
    private final String color;
    private int position = 0;

    public Piece(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Piece other)) return false;
        return Objects.equals(this.color, other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() { return color; }

    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public String getColor() { return color; }
}
