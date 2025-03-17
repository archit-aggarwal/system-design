// Step 1: Define an interface
interface Customer {
  String getName();
  boolean isNull();
}

// Step 2: Real Implementation
class RealCustomer implements Customer {
  private final String name;

  public RealCustomer(String name) {
      this.name = name;
  }

  @Override
  public String getName() {
      return name;
  }

  @Override
  public boolean isNull() {
      return false;
  }
}

// Step 3: Null Object Implementation
class NullCustomer implements Customer {
  @Override
  public String getName() {
      return "Not Available";
  }

  @Override
  public boolean isNull() {
      return true;
  }
}

// Step 4: Factory Method
class CustomerFactory {
  public static Customer getCustomer(String name) {
      if ("John".equalsIgnoreCase(name)) {
          return new RealCustomer("John Doe");
      }
      return new NullCustomer();  // Returns a null object instead of null
  }
}

// Step 5: Client Code
public class _02_Solution_NullObject {
  public static void main(String[] args) {
    Customer customer = CustomerFactory.getCustomer("Jane");

    // No need for null checks
    System.out.println("Customer: " + customer.getName());  
    // Prints "Not Available"
  }
}
