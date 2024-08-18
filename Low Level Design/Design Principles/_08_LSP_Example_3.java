public class _08_LSP_Example_3 {
  public static void main(String[] args) {
    try{
      Transaction transaction = new CreditCardTransaction_Bad(50);
      // expecting transaction to get processed as amount is positive
      String status = transaction.process(); 
      System.out.println("Payment Status : " + status);
    } catch(Exception e){
      System.out.println("ERROR : " + e.getMessage());
    }

    try{
      Transaction transaction = new CreditCardTransaction_Bad(150);
      // expecting success or failure status
      String status = transaction.process(); 
      System.out.println("Payment Status : " + status);
    } catch(Exception e){
      System.out.println("ERROR : " + e.getMessage());
    }

    try{
      Transaction transaction = new CreditCardTransaction_Good(50);
      // additional behavior of fees is acceptable/allowed
      String status = transaction.process();
      System.out.println("Payment Status : " + status);
    } catch(Exception e){
      System.out.println("ERROR : " + e.getMessage());
    }
  }
}

class Transaction {
  protected double amount;

  public Transaction(double amount) {
      this.amount = amount;
  }

  public String process() throws Exception {
      if (amount <= 0) {
          throw new Exception("Transaction amount must be greater than zero.");
      }
      // Process the transaction
      System.out.println("Processing transaction of amount: " + amount);
      return "Success"; // assume it return either success or failure always
  }
}

class CreditCardTransaction_Bad extends Transaction {
  public CreditCardTransaction_Bad(double amount) {
      super(amount);
  }

  @Override
  public String process() throws Exception {
      if (amount < 100) { // Strengthening pre-condition
          throw new Exception("Credit card transaction amount must be at least 100.");
      }

      System.out.println("Payment of amount: " + amount + " deducted. Now sending it to receiver");
      return "Pending"; // weakening post-condition (may be success or failure)
  }
}

class CreditCardTransaction_Good extends Transaction {
  public CreditCardTransaction_Good(double amount) {
      super(amount);
  }

  @Override
  public String process() throws Exception {
      if (amount < 100) {
        System.out.println("Small Transaction Charges of 10% are applicable");
        super.amount = super.amount + 0.1 * super.amount;
      }
      
      return super.process();
  }
}

