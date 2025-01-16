class PriceCalculator {
  public double calculatePrice(String vehicleType, double distance) {
    if ("Sedan".equalsIgnoreCase(vehicleType)) {
        return distance * 15; // Sedan pricing: ₹15 per km
    } else if ("SUV".equalsIgnoreCase(vehicleType)) {
        return distance * 20; // SUV pricing: ₹20 per km
    } else if ("Auto".equalsIgnoreCase(vehicleType)) {
        return distance * 10; // Auto pricing: ₹10 per km
    } else {
        throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
    }
  }
}
public class _01_Problem_Strategy {
  public static void main(String[] args) {
      PriceCalculator calc = new PriceCalculator();
      
      System.out.println(calc.calculatePrice("Sedan", 30));
      System.out.println(calc.calculatePrice("SUV", 20));
      System.out.println(calc.calculatePrice("Auto", 10));
  }
}


