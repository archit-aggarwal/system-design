import java.util.*;

class NotificationFactory {
  Map<NotificationType, Notification> notificationDB;
  
  public NotificationFactory() {
    notificationDB = new HashMap<>();
    notificationDB.put(NotificationType.EMAIL, new EmailNotification());
    notificationDB.put(NotificationType.SMS, new SMSNotification());
    notificationDB.put(NotificationType.PUSH, new PushNotification());
  }

  // this follows open closed principle
  public Notification getNotification(NotificationType notificationType) {
    Notification prototype = notificationDB.get(notificationType);
    if(prototype == null) return null;
    return prototype.clone(); // to ensure different objects are returned every time
  }
}

enum NotificationType {
  EMAIL, SMS, PUSH
}


interface Notification extends Cloneable {
  public void send(String message);
  public Notification clone();
}

class EmailNotification implements Notification {

  @Override
  public void send(String message) {
      System.out.println("Sending Email with Message : " + message);
  }

  @Override
  public Notification clone() {
      try {
          return (EmailNotification) super.clone();
      } catch (CloneNotSupportedException e) {
          throw new AssertionError();
      }
  }
  
}

class SMSNotification implements Notification {

  @Override
  public void send(String message) {
      System.out.println("Sending SMS with Message : " + message);
  }

  @Override
  public Notification clone() {
      try {
          return (SMSNotification) super.clone();
      } catch (CloneNotSupportedException e) {
          throw new AssertionError();
      }
  }
  
}

class PushNotification implements Notification {

  @Override
  public void send(String message) {
      System.out.println("Push Notification with Message : " + message);
  }
  
  @Override
  public Notification clone() {
      try {
          return (PushNotification) super.clone();
      } catch (CloneNotSupportedException e) {
          throw new AssertionError();
      }
  }
}

public class _02_Single_Factory_Prototype {
  public static void main(String[] args){
    NotificationFactory factory = new NotificationFactory();

    Notification email = factory.getNotification(NotificationType.EMAIL);
    email.send("Good Morning");

    Notification sms = factory.getNotification(NotificationType.SMS);
    sms.send("Good Afternoon");

    Notification push = factory.getNotification(NotificationType.PUSH);
    push.send("Good Evening");
  }
}