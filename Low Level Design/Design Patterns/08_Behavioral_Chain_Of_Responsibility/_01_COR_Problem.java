class Currency {
  private int amount;

  public Currency(int amount) {
      this.amount = amount;
  }

  public int getAmount() {
      return amount;
  }
}

class CoinDispenser {
  public void dispense(Currency currency) {
      int amount = currency.getAmount();

      // Handle ₹10 coins
      if (amount >= 10) {
          int numCoins = amount / 10;
          amount = amount % 10;
          System.out.println("Dispensing " + numCoins + " ₹10 coin(s)");
      }

      // Handle ₹5 coins
      if (amount >= 5) {
          int numCoins = amount / 5;
          amount = amount % 5;
          System.out.println("Dispensing " + numCoins + " ₹5 coin(s)");
      }

      // Handle ₹1 coins
      if (amount >= 1) {
          int numCoins = amount / 1;
          amount = amount % 1;
          System.out.println("Dispensing " + numCoins + " ₹1 coin(s)");
      }
  }
}

public class _01_COR_Problem {
    public static void main(String[] args) {
        CoinDispenser dispenser = new CoinDispenser();
        dispenser.dispense(new Currency(87)); 
    }
}