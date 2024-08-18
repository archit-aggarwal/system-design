import java.util.List;

public class _07_OCP_Example {
  
}

class NotificationService_Bad {
  public void sendNotification(String type, String message) {
      if (type.equals("Email")) {
          sendEmail(message);
      } else if (type.equals("SMS")) {
          sendSMS(message);
      } else if (type.equals("Push")) {
          sendPushNotification(message);
      }
  }

  private void sendEmail(String message) {
      // Email sending logic
      System.out.println("Sending email: " + message);
  }

  private void sendSMS(String message) {
      // SMS sending logic
      System.out.println("Sending SMS: " + message);
  }

  private void sendPushNotification(String message) {
      // Push notification logic
      System.out.println("Sending push notification: " + message);
  }
}


interface Notification {
  void send(String message);
}

class EmailNotification implements Notification {
  public void send(String message) {
      System.out.println("Sending email: " + message);
  }
}

class SMSNotification implements Notification {
  public void send(String message) {
      System.out.println("Sending SMS: " + message);
  }
}

class PushNotification implements Notification {
  public void send(String message) {
      System.out.println("Sending push notification: " + message);
  }
}

class NotificationService_Good {
  private List<Notification> notificationMethods;

  public NotificationService_Good(List<Notification> notificationMethods) {
      this.notificationMethods = notificationMethods;
  }

  public void sendNotifications(String message) {
      for (Notification notification : notificationMethods) {
          notification.send(message);
      }
  }
}