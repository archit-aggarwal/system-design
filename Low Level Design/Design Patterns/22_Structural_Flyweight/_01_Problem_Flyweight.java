import java.util.*;

// Represents an individual tree
class Tree {
  private String type;  // Every tree stores its own type (redundant)
  private int x, y;

  public Tree(String type, int x, int y) {
      this.type = type;
      this.x = x;
      this.y = y;
  }

  public void draw() {
      System.out.println("Drawing " + type + " tree at (" + x + "," + y + ")");
  }
}

public class _01_Problem_Flyweight {
  public static void main(String[] args) {
    List<Tree> forest = new ArrayList<>();
    for (int i = 0; i < 1000000; i++) {
        forest.add(new Tree("Oak", i % 1000, i / 1000));  
        // Duplicates "Oak" type unnecessarily
    }
    System.out.println("1 million trees created!");
  }
}

