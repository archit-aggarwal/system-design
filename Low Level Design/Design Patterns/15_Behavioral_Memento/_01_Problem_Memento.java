class TextEditor {
  private String content;

  public void write(String text) {
      this.content = text;
  }

  public void print() {
      System.out.println("Current Content: " + content);
  }
}

public class _01_Problem_Memento {
  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    editor.write("Version 1");
    editor.print();
    
    // Cannot undo or restore previous versions
    editor.write("Version 2");
    editor.print();
  }
}

