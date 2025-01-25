class FileSystem {
  public void createFile(String fileName) {
      System.out.println("Creating file: " + fileName);
  }

  public void deleteFile(String fileName) {
      System.out.println("Deleting file: " + fileName);
  }

  public void renameFile(String oldName, String newName) {
      System.out.println("Renaming file from " + oldName + " to " + newName);
  }
}

public class _01_Problem_Command {
  public static void main(String[] args) {
    FileSystem fileSystem = new FileSystem();

    // Directly calling file operations
    fileSystem.createFile("file1.txt");
    fileSystem.renameFile("file1.txt", "file2.txt");
    fileSystem.deleteFile("file2.txt");

    // Problem:
    // - No undo functionality
    // - Client is tightly coupled with file operation logic
    // - Hard to extend for new operations
  }
}
