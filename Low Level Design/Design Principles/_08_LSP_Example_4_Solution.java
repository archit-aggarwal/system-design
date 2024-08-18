abstract class Booking {
  protected int baseAmount;
  Booking(int baseAmount) 
    { this.baseAmount = baseAmount; }

  public abstract double bookTicket();
}

class TrainBooking extends Booking {
  TrainBooking(int baseAmount) { super(baseAmount); }

  public double bookTicketAdvance() {
    System.out.println("2% convenience fees for " +
      "advance booking in General Quota : " + baseAmount);
    return baseAmount + 0.02 * baseAmount;
  }

  @Override
  public double bookTicket(){
    System.out.println("5% convenience fees for " + 
    " booking in General Quota : " + baseAmount);
    return baseAmount + 0.05 * baseAmount;
  }
}

class TatkalBooking extends Booking {
  TatkalBooking(int baseAmount){ super(baseAmount); }

  @Override
  public double bookTicket(){
    System.out.println("10% convenience fees for " + 
      "booking in Tatkal Quota : " + baseAmount);
    return baseAmount + 0.1 * baseAmount;
  }
}

public class _08_LSP_Example_4_Solution {
  public static void main(String[] args) {
      Booking booking1 = new TatkalBooking(2500);
      booking1.bookTicket();

      TrainBooking booking2 = new TrainBooking(3000);
      booking2.bookTicketAdvance();
  }
}