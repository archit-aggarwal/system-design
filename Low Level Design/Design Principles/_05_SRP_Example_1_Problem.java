import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _05_SRP_Example_1_Problem {
  public static void main(String[] args){
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

class ReaderWriterApplication {
  private List<String> messages = new ArrayList<>();
  private Map<String, Integer> readers = new HashMap<>();

  public String read(String reader) {
      Integer ptr = readers.get(reader);
      if(ptr == null || ptr < 0 || ptr >= messages.size()) 
        return null;
      readers.put(reader, ptr + 1);
      return messages.get(ptr);
  }

  public void write(String message) {
    messages.add(message);
  }

  public void addReader(String reader){
    if(readers.containsKey(reader)) return;
    readers.put(reader, 0);
  }
}