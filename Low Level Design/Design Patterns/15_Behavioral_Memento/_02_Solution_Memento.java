import java.util.Stack;

// Originator: The object whose state is saved/restored
class TextEditor {
  private String content;

  public void write(String text) {
      this.content = text;
  }

  public TextEditorMemento save() {
      return new TextEditorMemento(content); // Save current state
  }

  public void restore(TextEditorMemento memento) {
      this.content = memento.state; // Restore state
  }

  public void print() {
      System.out.println("Current Content: " + content);
  }

  // Memento: Stores the state of the TextEditor: Inner Class
  class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String state) {
        this.state = state;
    }
  }
}

// Caretaker: Manages Memento objects
class Caretaker {
  private final Stack<TextEditor.TextEditorMemento> 
      mementoStack = new Stack<>();

  public void saveState(TextEditor editor) {
      mementoStack.push(editor.save());
  }

  public void undo(TextEditor editor) {
      if (!mementoStack.isEmpty()) {
          editor.restore(mementoStack.pop());
      }
  }
}

public class _02_Solution_Memento {
  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    Caretaker caretaker = new Caretaker();

    editor.write("Version 1");
    caretaker.saveState(editor);

    editor.write("Version 2");
    caretaker.saveState(editor);

    editor.write("Version 3");
    editor.print();

    caretaker.undo(editor); // Undo to Version 2
    editor.print();

    caretaker.undo(editor); // Undo to Version 1
    editor.print();
  }
}
