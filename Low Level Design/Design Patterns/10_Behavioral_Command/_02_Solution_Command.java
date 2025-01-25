import java.util.Stack;

// Receiver
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

interface Command {
  void execute();
  void undo();
}

class CreateFileCommand implements Command {
  private FileSystem fileSystem;
  private String fileName;

  public CreateFileCommand(
      FileSystem fileSystem, String fileName) {
      this.fileSystem = fileSystem;
      this.fileName = fileName;
  }

  @Override
  public void execute() 
  { fileSystem.createFile(fileName); }

  @Override
  public void undo() 
  { fileSystem.deleteFile(fileName); }
}

class DeleteFileCommand implements Command {
  private FileSystem fileSystem;
  private String fileName;

  public DeleteFileCommand(
      FileSystem fileSystem, String fileName) {
      this.fileSystem = fileSystem;
      this.fileName = fileName;
  }

  @Override
  public void execute() 
  { fileSystem.deleteFile(fileName); }

  @Override
  public void undo() 
  { fileSystem.createFile(fileName); }
}

class RenameFileCommand implements Command {
  private FileSystem fileSystem;
  private String oldName;
  private String newName;

  public RenameFileCommand(FileSystem fileSystem, 
        String oldName, String newName) {
      this.fileSystem = fileSystem;
      this.oldName = oldName;
      this.newName = newName;
  }

  @Override
  public void execute() 
  { fileSystem.renameFile(oldName, newName); }

  @Override
  public void undo() 
  { fileSystem.renameFile(newName, oldName); }
}

class CommandInvoker {
  private Stack<Command> commandHistory = new Stack<>();

  public void executeCommand(Command command) {
      command.execute();
      commandHistory.push(command);
  }

  public void undoLastCommand() {
      if (!commandHistory.isEmpty()) {
          Command lastCommand = commandHistory.pop();
          lastCommand.undo();
      } else {
          System.out.println("No commands to undo.");
      }
  }
}

public class _02_Solution_Command {
  public static void main(String[] args) {
    FileSystem fileSystem = new FileSystem();
    CommandInvoker invoker = new CommandInvoker();

    // Create and execute commands
    Command createFile = new 
      CreateFileCommand(fileSystem, "file1.txt");
    Command renameFile = new 
      RenameFileCommand(fileSystem, 
          "file1.txt", "file2.txt");
    Command deleteFile = new 
      DeleteFileCommand(fileSystem, "file2.txt");

    // Executing commands
    invoker.executeCommand(createFile);
    invoker.executeCommand(renameFile);
    invoker.executeCommand(deleteFile);

    System.out.println("\nUndoing last command:");
    invoker.undoLastCommand();

    System.out.println("\nUndoing another command:");
    invoker.undoLastCommand();
  }
}
