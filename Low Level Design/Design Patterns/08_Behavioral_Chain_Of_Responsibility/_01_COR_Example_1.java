import java.util.Scanner;

abstract class DispenseChain {
  protected DispenseChain nextChain;

  public DispenseChain getNextChain() 
  { return this.nextChain; }

  public void setNextChain(DispenseChain nextChain) 
  { this.nextChain = nextChain; }

  public abstract void dispense(Currency currency);
}

class Currency {
  private int amount;

  public Currency(int amount) 
  { this.amount = amount; }

  public int getAmount() 
  { return amount; }
}

class TenRupeesCoinDispenser extends DispenseChain {
  @Override
  public void dispense(Currency currency) {
      if (currency.getAmount() >= 10) {
          int numNotes = currency.getAmount() / 10;
          int remainder = currency.getAmount() % 10;
          System.out.println("Dispensing " + numNotes + " ₹10 coin(s)");
          if (remainder != 0) nextChain.dispense(new Currency(remainder));
      } else {
          nextChain.dispense(currency);
      }
  }
}

class FiveRupeesCoinDispenser extends DispenseChain {
  @Override
  public void dispense(Currency currency) {
      if (currency.getAmount() >= 5) {
          int numNotes = currency.getAmount() / 5;
          int remainder = currency.getAmount() % 5;
          System.out.println("Dispensing " + numNotes + " ₹5 coin(s)");
          if (remainder != 0) nextChain.dispense(new Currency(remainder));
      } else {
          nextChain.dispense(currency);
      }
  }
}

class OneRupeeCoinDispenser extends DispenseChain {
  @Override
  public void dispense(Currency currency) {
      if (currency.getAmount() >= 1) {
          int numNotes = currency.getAmount() / 1;
          int remainder = currency.getAmount() % 1;
          System.out.println("Dispensing " + numNotes + " ₹1 coin(s)");
          if (remainder != 0) nextChain.dispense(new Currency(remainder));
      } else {
          nextChain.dispense(currency);
      }
  }
}

public class _01_COR_Example_1 {
  private static DispenseChain getATMDispenseChain() {
    DispenseChain chain = new TenRupeesCoinDispenser();
    chain.setNextChain(new FiveRupeesCoinDispenser());
    chain.getNextChain().setNextChain(new OneRupeeCoinDispenser());
    return chain;
  }

  public static void main(String[] args) {
    DispenseChain atmDispenser = getATMDispenseChain();

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the amount to withdraw: ");

    int amount = scanner.nextInt();
    atmDispenser.dispense(new Currency(amount));

    scanner.close();
  }
}