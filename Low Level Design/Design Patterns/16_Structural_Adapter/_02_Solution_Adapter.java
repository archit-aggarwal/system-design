// Target Interface (Legacy system expects this payment interface)
interface PaymentProcessor {
  void pay(Account account, double amount);
}

// Existing Payment Gateway (Paytm)
class PaytmPayment implements PaymentProcessor {
  @Override
  public void pay(Account account, double amount) {
      System.out.println("Payment of ₹" + amount 
        + " made via Paytm for account id: " + account.id);
  }
}

// New Third-Party API (PayPal - Different Interface)
class PayPalAPI {
  public void makePayment(String email, double amount, String currency) {
      System.out.println("Payment of " + currency
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

class PayPalAdapter implements PaymentProcessor {
  private PayPalAPI payPalAPI;
  private String currency;

  public PayPalAdapter(PayPalAPI payPalAPI, String currency) {
      this.payPalAPI = payPalAPI;
      this.currency = currency;
  }

  @Override
  public void pay(Account account, double amount) {
      // PayPal uses email instead of account ID
      payPalAPI.makePayment(account.email, amount, currency);
  }
}


public class _02_Solution_Adapter {
  public static void main(String[] args) {
    Account user1 = new Account("123", "user1@example.com");
    Account user2 = new Account("456", "user2@example.com");

    PaymentProcessor paytm = new PaytmPayment();
    paytm.pay(user1, 500.0);

    // PayPal Payment via Adapter (Supports Multiple Currencies)
    PaymentProcessor paypalAdapter = new PayPalAdapter(new PayPalAPI(), "$");
    paypalAdapter.pay(user2, 75.0);
  }
}
