// Target Interface (Legacy system expects this payment interface)
interface PaymentProcessor {
  void pay(Account account, double amount);
}

// Existing Payment Gateway (Stripe)
class PaytmPayment implements PaymentProcessor {
  @Override
  public void pay(Account account, double amount) {
      System.out.println("Payment of ₹" + amount 
        + " made via Stripe for account id: " + account.id);
  }
}

// New Third-Party API (PayPal - Different Interface)
class PayPalAPI {
  public void makePayment(String email, double amount, String currency) {
      System.out.println("Payment of " + currency + " " 
        + amount + " made via PayPal for email: " + email);
  }
}

class Account {
  public String id, email;

  Account(String id, String email) {
    this.id = id;
    this.email = email;
  }
}

public class _01_Problem_Adapter {
  public static void main(String[] args) {
    Account acc = new Account("userId1", "user@gmail.com");
    PaymentProcessor stripe = new PaytmPayment();
    stripe.pay(acc, 50.0); // Works fine

    // ❌ PROBLEM: PayPal has a different method signature
    // PayPalAPI paypal = new PayPalAPI();
    // paypal.makePayment("user@example.com", 50.0, "₹"); 
    // Doesn't fit into PaymentProcessor
  }
}
