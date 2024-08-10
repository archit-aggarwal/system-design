interface PaymentSystemFactory {
  public PaymentSystem createPaymentSystem();
}

class UPIPaymentFactory implements PaymentSystemFactory {
  private String upiId;

  public UPIPaymentFactory(String upiId) {
      this.upiId = upiId;
  }

  @Override
  public PaymentSystem createPaymentSystem() {
      UPI upi = new UPI();
      upi.setUpiId(upiId);
      return upi;
  }
}

class DebitCardPaymentFactory implements PaymentSystemFactory {
  private String debitCardNo;

  public DebitCardPaymentFactory(String debitCardNo) {
      this.debitCardNo = debitCardNo;
  }

  @Override
  public PaymentSystem createPaymentSystem() {
      DebitCard debitCard = new DebitCard();
      debitCard.setDebitCardNo(debitCardNo);
      return debitCard;
  }
}

interface PaymentSystem {
  public void sendMoney(double amount);
  public void receiveMoney(double amount);
}

class UPI implements PaymentSystem {
  String upiId;

  public void setUpiId(String upiId){
    this.upiId = upiId;
  }

  @Override
  public void sendMoney(double amount) {
    System.out.println("Sending Rs. " + amount + " Using UPI Id : " + upiId);
  }

  @Override
  public void receiveMoney(double amount) {
    System.out.println("Receive Rs. " + amount + " Using UPI Id : " + upiId);
  }
}

class DebitCard implements PaymentSystem {
  String debitCardNo;

  public void setDebitCardNo(String debitCardNo){
    this.debitCardNo = debitCardNo;
  }

  @Override
  public void sendMoney(double amount) {
    System.out.println("Sending Rs. " + amount + " Using Debit Card : " + debitCardNo);
  }

  @Override
  public void receiveMoney(double amount) {
    System.out.println("Receive Rs. " + amount + " Using Debit Card : " + debitCardNo);
  }
}


public class _03_Factory_Method {
  public static void main(String[] args) {
    PaymentSystemFactory upiFactory = 
      new UPIPaymentFactory("user@upi");
    PaymentSystem upiPayment = upiFactory.createPaymentSystem();
    upiPayment.sendMoney(1000);
    upiPayment.receiveMoney(500);

    // Using Debit Card Payment System
    PaymentSystemFactory debitCardFactory = 
      new DebitCardPaymentFactory("1234-5678-9012-3456");
    PaymentSystem debitCardPayment = debitCardFactory.createPaymentSystem();
    debitCardPayment.sendMoney(2000);
    debitCardPayment.receiveMoney(1000);
  }
}
