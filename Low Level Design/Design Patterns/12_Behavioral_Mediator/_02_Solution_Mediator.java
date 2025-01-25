import java.util.ArrayList;
import java.util.List;

class Chatroom {
  private List<User> users = new ArrayList<>();

  public void registerUser(User user) {
      users.add(user);
      user.setChatroom(this);
  }

  public void registerBot(Bot bot) {
      bot.setChatroom(this);
  }

  public void sendMessage(String sender, 
      String message, Object senderObj) {
        
    System.out.println(sender + " sends: " + message);

    // Notify all users
    for (User user : users) {
        if (user != senderObj) {
            user.receiveMessage(sender, message);
        }
    }
  }
}

class User {
  private String name;
  private Chatroom chatroom;

  public User(String name) {
      this.name = name;
  }

  public void setChatroom(Chatroom chatroom) {
      this.chatroom = chatroom;
  }

  public void sendMessage(String message) {
      chatroom.sendMessage(name, message, this);
  }

  public void receiveMessage(String sender, String message) {
      System.out.println(name + " received message " 
      + "from " + sender + ": " + message);
  }
}

class Bot {
  private String name;
  private Chatroom chatroom;

  public Bot(String name) {
      this.name = name;
  }

  public void setChatroom(Chatroom chatroom) {
      this.chatroom = chatroom;
  }

  public void sendMessage(String message) {
      chatroom.sendMessage(name, message, this);
  }
}

public class _02_Solution_Mediator {
  public static void main(String[] args) {
    Chatroom chatroom = new Chatroom();

    User u1 = new User("Archit");
    User u2 = new User("Bhawna");
    User u3 = new User("Chirag");
    Bot bot = new Bot("WhatsApp Bot");

    // Register users and bot with the chatroom
    chatroom.registerUser(u1);
    chatroom.registerUser(u2);
    chatroom.registerUser(u3);
    chatroom.registerBot(bot);

    // Users and bot communicate via the chatroom
    u1.sendMessage("Good Morning");
    bot.sendMessage("Update App");
  }
}
