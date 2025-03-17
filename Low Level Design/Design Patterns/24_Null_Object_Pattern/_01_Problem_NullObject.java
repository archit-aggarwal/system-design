interface Customer {
  String getName();
}

// Concrete Customer
class RealCustomer implements Customer {
  private final String name;

  public RealCustomer(String name) {
      this.name = name;
  }

  @Override
  public String getName() {
      return name;
  }
}

// Client Code (Without Null Object)
public class _01_Problem_NullObject {
  public static Customer getCustomer(String name) {
      // Simulating a missing customer
      if ("John".equalsIgnoreCase(name)) {
          return new RealCustomer("John Doe");
      }
      return null;
  }
  
  public static void main(String[] args) {
    Customer customer = getCustomer("Jane");

    // We have to manually check for null everywhere
    if (customer != null) {
        System.out.println("Customer: " + customer.getName());
    } else {
        System.out.println("Customer not found");
    }
  }
}
