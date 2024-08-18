class TrainBooking {
  protected int baseAmount;
  TrainBooking(int baseAmount) 
    { this.baseAmount = baseAmount; }

  public double advanceBooking() throws Exception {
    System.out.println("2% convenience fees for " 
      + "advance booking in General Quota : " + baseAmount);
    return baseAmount + 0.02 * baseAmount;
  }

  public double booking(){
    System.out.println("5% convenience fees for " 
      + "booking in General Quota : " + baseAmount);
    return baseAmount + 0.05 * baseAmount;
  }
}

class TatkalBooking extends TrainBooking {
  TatkalBooking(int baseAmount){ super(baseAmount); }

  @Override
  public double advanceBooking() throws Exception {
    throw new Exception
    ("Advance Booking not allowed in Tatkal Quota");
  }

  @Override
  public double booking(){
    System.out.println("10% convenience fees for " 
      + "booking in Tatkal Quota : " + baseAmount);
    return baseAmount + 0.1 * baseAmount;
  }
}

public class _08_LSP_Example_4_Problem {
  public static void main(String[] args) {
      TrainBooking booking = new TatkalBooking(2500);
      try {
          System.out.println(booking.advanceBooking());
      } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
      }
  }
}