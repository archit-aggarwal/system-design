// Implementor - Defines the color hierarchy
interface PieceColor {
  void displayColor();
}

// Concrete Implementors
class White implements PieceColor {
  @Override
  public void displayColor() {
      System.out.println("White Piece");
  }
}

class Black implements PieceColor {
  @Override
  public void displayColor() {
      System.out.println("Black Piece");
  }
}

// Abstraction - Chess Piece
abstract class ChessPiece {
  protected PieceColor color;

  public ChessPiece(PieceColor color) {
      this.color = color;
  }

  abstract void move();
}

// Refined Abstractions - Different Chess Pieces
class King extends ChessPiece {
  public King(PieceColor color) {
      super(color);
  }

  @Override
  void move() {
      color.displayColor();
      System.out.println("King moves one square in any direction.");
  }
}

class Queen extends ChessPiece {
  public Queen(PieceColor color) {
      super(color);
  }

  @Override
  void move() {
      color.displayColor();
      System.out.println("Queen moves any number of squares in any direction.");
  }
}

public class _02_Solution_Bridge {
  public static void main(String[] args) {
    ChessPiece whiteKing = new King(new White());
    whiteKing.move();
    // Output:
    // White Piece
    // King moves one square in any direction.

    ChessPiece blackQueen = new Queen(new Black());
    blackQueen.move();
    // Output:
    // Black Piece
    // Queen moves any number of squares in any direction.
  }
}
