import java.util.ArrayList;
import java.util.List;

// Individual File Class
class File {
    private String name;
    
    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Folder Class
class Folder {
    private String name;
    private List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);
        for (File file : files) {
            file.showDetails();
        }
    }
}

public class _01_Problem_Composite {
  public static void main(String[] args) {
    File file1 = new File("document.pdf");
    File file2 = new File("photo.jpg");

    Folder folder = new Folder("MyFolder");
    folder.addFile(file1);
    folder.addFile(file2);

    folder.showDetails();

    // Folders and Files are separate types → Clients need to handle them differently.
    // No recursion → A folder cannot contain another folder without extra logic.
    // No uniformity → Methods must handle folders and files separately.
  }  
}
