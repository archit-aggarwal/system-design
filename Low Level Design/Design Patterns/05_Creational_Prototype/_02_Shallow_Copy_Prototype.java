public class _02_Shallow_Copy_Prototype {
  public static void main(String[] args) throws Exception{
    Address address = new Address("Bangalore", "Karnataka");
    Employee employee1 = new 
      Developer("Archit", "Aggarwal", "SDE", address);
    Employee employee2 = (Employee) employee1.clone();

    System.out.println(employee1.hashCode() + " @ " + employee1);
    System.out.println(employee2.hashCode() + " @ " + employee2);

    address.setCity("Hyderabad");
    address.setState("Telangana");

    System.out.println(employee1.hashCode() + " @ " + employee1);
    System.out.println(employee2.hashCode() + " @ " + employee2);
  }
}

abstract class Employee implements Cloneable {
  private String firstName;
  private String lastName;
  private Address address;

  public Employee(String firstName, 
    String lastName, Address address){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public Address getAddress() {
    return this.address;
  }

  @Override
  protected Object clone() 
    throws CloneNotSupportedException {
    return super.clone(); // Object's clone call
  }
}

class Developer extends Employee {
  private String role;

  public Developer(String firstName, 
    String lastName, String role, 
    Address address) {
    super(firstName, lastName, address);
    this.role = role;
  }

  @Override
  public String toString() {
    return "Developer [role=" + role + 
      ", getFirstName()=" + getFirstName() 
      + ", getLastName()=" + getLastName()
      + ", getAddress()=" + getAddress() + "]";
  }
}

class Address {

  private String city;
  private String state;

  public Address(String city, String state) {
      this.city = city;
      this.state = state;
  }

  @Override
  public String toString() {
    return this.hashCode() + " @ Address " 
      + "[city=" + city 
      + ", state=" + state + "]";
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }
}