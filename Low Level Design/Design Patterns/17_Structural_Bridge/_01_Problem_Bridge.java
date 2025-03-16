// Single hierarchy combining Piece Type & Color - Leads to Class Explosion
abstract class ChessPiece {
  abstract void move();
}

// White Pieces
class WhiteKing extends ChessPiece {
  @Override
  void move() {
      System.out.println("White King moves one square in any direction.");
  }
}

class WhiteQueen extends ChessPiece {
  @Override
  void move() {
      System.out.println("White Queen moves any number of squares in any direction.");
  }
}

// Black Pieces
class BlackKing extends ChessPiece {
  @Override
  void move() {
      System.out.println("Black King moves one square in any direction.");
  }
}

class BlackQueen extends ChessPiece {
  @Override
  void move() {
      System.out.println("Black Queen moves any number of squares in any direction.");
  }
}

public class _01_Problem_Bridge {
  public static void main(String[] args) {
    ChessPiece whiteKing = new WhiteKing();
    whiteKing.move(); 
    // White King moves one square in any direction.

    ChessPiece blackQueen = new BlackQueen();
    blackQueen.move(); 
    // Black Queen moves any number of squares in any direction.
  }
}

