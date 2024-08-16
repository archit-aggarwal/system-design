public class _03_Composition_Example2 {
  public static void main(String[] args){
    PaytmAccount acc = new PaytmAccount();
    acc.processRefund(1000);

    acc.setUpi("archit@paytm");
    acc.processRefund(1000);
  }
}

class Wallet {
  public void processRefund(double amount) {
      System.out.println("Refunding ₹ " + amount + " to the Wallet.");
  }
}

class UPI {
  String upiId;

  public UPI(String upiId){
    this.upiId = upiId;
  }

  public void processRefund(double amount) {
      System.out.println("Refunding ₹ " + amount + " to the UPI " + upiId);
  }
}

// Multiple Inheritance Not Possible in Java
/* 
class PaytmAccount extends Wallet, UPI {
  public void processRefund(double amount) {
      System.out.println("Processing Refund to Wallet or UPI");
  }
}
*/

class PaytmAccount {
  private Wallet wallet = new Wallet();
  private UPI upi;

  public void setUpi(String upiId) {
    this.upi = new UPI(upiId);
  }

  public void processRefund(double amount) {
    if(upi == null) wallet.processRefund(amount);
    else upi.processRefund(amount);
  }
}
