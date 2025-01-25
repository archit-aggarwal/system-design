import java.util.ArrayList;
import java.util.List;

class User {
  private String name;
  private List<User> connectedUsers;

  public User(String name) {
      this.name = name;
      connectedUsers = new ArrayList<>();
  }

  public void connect(User user) {
    if(connectedUsers.contains(user)) return;
    connectedUsers.add(user);
    user.connect(this);
  }

  public void sendMessage(String message) {
    for (User user : connectedUsers) {
        user.receiveMessage(this.name, message);
    }
  }

  public void receiveMessage(String sender, String message) {
      System.out.println(this.name + " received message from "
      + sender + ": " + message);
  }
}

class Bot {
  private String name;
  private List<User> users;

  public Bot(String name) {
    this.name = name;
    users = new ArrayList<>();
  }

  public void connect(User user) {
    users.add(user);
  }

  public void sendMessage(String message) {
    for (User user : users) {
        user.receiveMessage(this.name, message);
    }
  }
}

public class _01_Problem_Mediator {
  public static void main(String[] args) {
    Bot bot = new Bot("Whatsapp bot");

    User u1 = new User("archit");
    User u2 = new User("bhawna");
    User u3 = new User("chirag");

    u1.connect(u2);
    u1.connect(u3);

    bot.connect(u1);
    bot.connect(u2);

    u1.sendMessage("Good Morning");
    bot.sendMessage("Update App");
  }  
}
