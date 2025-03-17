import java.util.ArrayList;
import java.util.List;

// Step 1: Define a common Component interface
interface FileSystemItem {
  void showDetails();
}

// Step 2: Implement Leaf (File)
class File implements FileSystemItem {
  private String name;

  public File(String name) {
      this.name = name;
  }

  @Override
  public void showDetails() {
      System.out.println("File: " + name);
  }
}

// Step 3: Implement Composite (Folder)
class Folder implements FileSystemItem {
  private String name;
  private List<FileSystemItem> items = new ArrayList<>();

  public Folder(String name) {
      this.name = name;
  }

  public void addItem(FileSystemItem item) {
      items.add(item);
  }

  @Override
  public void showDetails() {
      System.out.println("Folder: " + name);
      for (FileSystemItem item : items) {
          item.showDetails();
      }
  }
}


public class _02_Solution_Composite {
  public static void main(String[] args) {
    FileSystemItem file1 = new File("document.pdf");
    FileSystemItem file2 = new File("photo.jpg");

    Folder folder1 = new Folder("MyFolder");
    folder1.addItem(file1);
    folder1.addItem(file2);

    Folder root = new Folder("Root");
    root.addItem(folder1);
    root.addItem(new File("readme.txt"));

    root.showDetails();

    // ✔ Uniformity → Files and Folders are treated the same way using FileSystemItem.
    // ✔ Recursion → A Folder can contain both Files and other Folders.
    // ✔ Extensibility → Adding more features (e.g., size calculation, permissions) is easier.
  }  
}
