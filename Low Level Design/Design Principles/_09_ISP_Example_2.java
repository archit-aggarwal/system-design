public class _09_ISP_Example_2 {
  
}

interface CodeEditor {
  void undo();
  void redo();
  void copy();
  void paste();
}

class LeetcodePractice implements CodeEditor{
  public void undo() 
  { System.out.println("Perform Undo"); }

  public void redo()
  { System.out.println("Perform Redo"); }

  public void copy() 
  { System.out.println("Perform Copy"); }

  public void paste()
  { System.out.println("Perform Paste"); }
}

class LeetcodeContest implements CodeEditor {
  public void undo()
  { System.out.println("Perform Undo"); }

  public void redo()
  { System.out.println("Perform Redo"); }

  public void copy() 
  { /* do nothing function */ }

  public void paste() 
  { /* do nothing function */ }
}

interface CopyPasteEditor {
  void copy();
  void paste();
}

interface UndoRedoEditor {
  void undo();
  void redo();
}

class HackerrankPractice implements CopyPasteEditor, UndoRedoEditor{
  public void undo() 
  { System.out.println("Perform Undo"); }

  public void redo()
  { System.out.println("Perform Redo"); }

  public void copy() 
  { System.out.println("Perform Copy"); }

  public void paste()
  { System.out.println("Perform Paste"); }
}

class HackerrankContest implements UndoRedoEditor {
  public void undo()
  { System.out.println("Perform Undo"); }

  public void redo()
  { System.out.println("Perform Redo"); }
}