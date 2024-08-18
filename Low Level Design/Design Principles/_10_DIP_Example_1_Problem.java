public class _10_DIP_Example_1_Problem {
  
}


// high level module
class NotificationService {
  // low level module dependency
  private EmailSender emailSender;

  // dependency injection (via constructor)
  public NotificationService() {
      this.emailSender = new EmailSender();
  }

  public void sendNotification(String message) {
      // delegation (invokation of low level module)
      emailSender.sendEmail(message);
  }
}

// low level module
class EmailSender {
  public void sendEmail(String message) {
      System.out.println("Sending email: " + message);
  }
}
