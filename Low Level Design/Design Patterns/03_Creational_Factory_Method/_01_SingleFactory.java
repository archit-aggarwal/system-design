class FileFactory {
  // violates open-closed principle
  public File getFile(String fileType, String content) {
    if(fileType.equalsIgnoreCase("Java"))
      return new JavaFile(content);
    else if(fileType.equalsIgnoreCase("C++"))
      return new CPPFile(content);
    else if(fileType.equalsIgnoreCase("Javascript"))
      return new JSFile(content);
    else return null;
  }
}

abstract class File {
  String content;

  public File(String content){
    this.content = content;
  }

  abstract public void read();
}

class JavaFile extends File {
  public JavaFile(String content){
    super(content);
  }

  @Override
  public void read() {
    System.out.println("Reading Java File"
      + " Content : " + this.content);
  }
}

class CPPFile extends File {
  public CPPFile(String content){
    super(content);
  }

  @Override
  public void read() {
    System.out.println("Reading C++ File " 
      + "Content : " + this.content);
  }
}

class JSFile extends File {
  public JSFile(String content){
    super(content);
  }

  @Override
  public void read() {
    System.out.println("Reading Javascript " 
      + "Content : " + this.content);
  }
}

public class _01_SingleFactory {
  public static void main(String[] args) {
    FileFactory factory = new FileFactory();

    File java = factory.getFile("Java", "System.out.println(\"Hello World\");");
    java.read();

    File cpp = factory.getFile("C++", "cout << \"hello world\";");
    cpp.read();

    File javascript = factory.getFile("Javascript", "console.log(\'Hello World\')");
    javascript.read();
  }
}

