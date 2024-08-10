import java.util.*;

public class _03_Deep_Copy_Prototype {
  public static void main(String[] args) throws Exception{
    Address address = new Address("Bangalore", "Karnataka");
    List<String> languages = new ArrayList<>();
    languages.add("Java"); languages.add("C++");

    Employee employee1 = new 
      Developer("Archit", "Aggarwal", 
            "SDE", address, languages);
    Employee employee2 = (Employee) employee1.clone();

    System.out.println(employee1.hashCode() + " @ " + employee1);
    System.out.println(employee2.hashCode() + " @ " + employee2);

    address.setCity("Hyderabad");
    address.setState("Telangana");
    languages.add("Python");

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
    Employee cloned = (Employee) super.clone(); 
    // object clone call
    cloned.address = (Address) address.clone(); 
    // Deep copy of address
    return cloned;
  }
}

class Developer extends Employee {
  private String role;
  private List<String> languages;

  public Developer(String firstName, 
    String lastName, String role, 
    Address address, List<String> languages) {
    super(firstName, lastName, address);
    this.role = role;
    this.languages = languages;
  }

  @Override
  public String toString() {
    return "Developer [role=" + role 
    + ", languages=" + languages 
    + ", getFirstName()=" + getFirstName()
    + ", getLastName()=" + getLastName() 
    + ", getAddress()=" + getAddress() + "]";
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
      Developer cloned = (Developer) super.clone(); 
      // employee clone call
      cloned.languages = new ArrayList<>(this.languages); 
      // Deep copy of languages
      return cloned;
  }
}

class Address implements Cloneable {

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

  @Override
  protected Object clone() 
      throws CloneNotSupportedException {
    return super.clone(); // object's clone call
    // to deep copy address inside employee
  }
  
}