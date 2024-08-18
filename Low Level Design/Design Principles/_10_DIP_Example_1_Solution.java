public class _10_DIP_Example_1_Solution {
  public static void main(String[] args) {
    NotificationService service = 
      new NotificationService(new EmailSender());
    service.sendNotification("Good Morning");

    service = new NotificationService(new SMSSender());
    service.sendNotification("Good Evening");
  }
}

// high level module
class NotificationService {
  // dependency on abstraction
  private Notification notification;

  // dependency injection (via constructor)
  public NotificationService(Notification notification) {
      this.notification = notification;
  }

  public void sendNotification(String message) {
      // delegation (invokation of low level module)
      notification.notify(message);
  }
}

// abstraction (interface)
interface Notification {
  public void notify(String message);
}

// low level modules (implementing interface)
class EmailSender implements Notification {
  @Override
  public void notify(String message) {
      System.out.println("Sending email: " + message);
  }
}

class SMSSender implements Notification {
  @Override
  public void notify(String message) {
      System.out.println("Sending SMS: " + message);
  }
} 