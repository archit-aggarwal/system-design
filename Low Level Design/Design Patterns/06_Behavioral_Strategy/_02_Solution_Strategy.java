
interface PricingStrategy {
  double calculatePrice(double distance);
}

class SedanPricingStrategy implements PricingStrategy {
  @Override
  public double calculatePrice(double distance) {
      return distance * 15; // ₹15 per km
  }
}

class SuvPricingStrategy implements PricingStrategy {
  @Override
  public double calculatePrice(double distance) {
      return distance * 20; // ₹20 per km
  }
}

class AutoPricingStrategy implements PricingStrategy {
  @Override
  public double calculatePrice(double distance) {
      return distance * 10; // ₹10 per km
  }
}

class PricingService {
  private PricingStrategy pricingStrategy;

  // Set the strategy at runtime
  public void setPricingStrategy(PricingStrategy pricingStrategy) {
      this.pricingStrategy = pricingStrategy;
  }

  public double calculatePrice(double distance) {
      if (pricingStrategy == null) {
          throw new IllegalStateException("Pricing strategy not set");
      }
      return pricingStrategy.calculatePrice(distance);
  }
}

public class _02_Solution_Strategy {
  public static void main(String[] args) {
    PricingService calc = new PricingService();

    calc.setPricingStrategy(new SedanPricingStrategy());
    System.out.println("Sedan Price: ₹" + calc.calculatePrice(30));

    calc.setPricingStrategy(new SuvPricingStrategy());
    System.out.println("SUV Price: ₹" + calc.calculatePrice(20));

    calc.setPricingStrategy(new AutoPricingStrategy());
    System.out.println("Auto Price: ₹" + calc.calculatePrice(10));
  }
}
