import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _05_SRP_Example_1_Solution {
  public static void main(String[] args) {
    ReaderWriterApplication app = new ReaderWriterApplication();

    String reader1 = "SMS_Notification";
    String reader2 = "Email_Notification";
    app.addReader(reader1);
    app.addReader(reader2);
    
    app.write("Good Morning");
    app.write("Good Afternoon");
    app.write("Good Evening");
    app.write("Good Night");

    System.out.println(app.read(reader1));
    System.out.println(app.read(reader2));
    System.out.println(app.read(reader2));
    System.out.println(app.read(reader1));
    System.out.println(app.read(reader1));
    System.out.println(app.read(reader1));
    System.out.println(app.read(reader1));
    System.out.println(app.read(reader2)); 
  }
}

class Reader {
  private Map<String, Integer> readers = new HashMap<>();

  public void addReader(String reader) {
      if (!readers.containsKey(reader)) {
          readers.put(reader, 0);
      }
  }

  public String read(String reader, List<String> messages) {
      Integer ptr = readers.get(reader);
      if (ptr == null || ptr < 0 || ptr >= messages.size()) {
          return null;
      }
      readers.put(reader, ptr + 1);
      return messages.get(ptr);
  }
}

class Writer {
  private List<String> messages = new ArrayList<>();

  public void write(String message) {
      messages.add(message);
  }

  public List<String> getMessages() {
    return messages;
  }
}

class ReaderWriterApplication {
  private Reader reader = new Reader();
  private Writer writer = new Writer();

  public String read(String readerName) {
      return reader.read(readerName, writer.getMessages());
  }

  public void write(String message) {
      writer.write(message);
  }

  public void addReader(String readerName) {
      reader.addReader(readerName);
  }
}