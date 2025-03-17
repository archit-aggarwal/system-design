import java.util.*;

// Flyweight (Shared Tree Type)
class TreeType {
  private final String type;

  public TreeType(String type) {
      this.type = type;
  }

  public void draw(int x, int y) {
      System.out.println("Drawing " + type + " tree at (" + x + "," + y + ")");
  }
}

// Flyweight Factory - Ensures trees are reused instead of created redundantly
class TreeFactory {
  private static final Map<String, TreeType> treeTypes = new HashMap<>();

  public static TreeType getTreeType(String type) {
      treeTypes.putIfAbsent(type, new TreeType(type));
      return treeTypes.get(type);
  }
}

// Unshared Flyweight - Stores unique tree positions
class Tree {
  private final int x, y;
  private final TreeType type;  // Shared flyweight

  public Tree(int x, int y, String type) {
      this.x = x;
      this.y = y;
      this.type = TreeFactory.getTreeType(type);  // Reusing tree type
  }

  public void draw() {
      type.draw(x, y);
  }
}

public class _02_Solution_Flyweight {
  public static void main(String[] args) {
      // Creates 1 million trees with shared types (Optimized Memory Usage)
      List<Tree> forest = new ArrayList<>();
      for (int i = 0; i < 1_000_000; i++) {
          forest.add(new Tree(i % 1000, i / 1000, "Oak"));  
          // Reuses "Oak" type
      }
      System.out.println("1 million trees created efficiently!");
  }
}