import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class _04_Deep_Copy_Serializable {
  public static void main(String[] args) throws Exception{
    Address address = new Address("Bangalore", "Karnataka");
    List<String> languages = new ArrayList<>();
    languages.add("Java"); languages.add("C++");

    Employee employee1 = new 
      Developer("Archit", "Aggarwal", "SDE", address, languages);

    // Deep copy using serialization
    Employee employee2 = deepCopy(employee1);

    // Display both employees
    System.out.println(employee1.hashCode() + " @ " + employee1);
    System.out.println(employee2.hashCode() + " @ " + employee2);

    // Modify original objects
    address.setCity("Hyderabad");
    languages.add("Python");

    // Display both employees again to show that employee2 remains unchanged
    System.out.println(employee1.hashCode() + " @ " + employee1);
    System.out.println(employee2.hashCode() + " @ " + employee2);
  }

  // Method to deep copy an object using serialization
  public static <T> T deepCopy(T object) {
    try {
      // Serialize the object
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(byteOut);
      out.writeObject(object);
      
      // Deserialize the object
      ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
      ObjectInputStream in = new ObjectInputStream(byteIn);
      return (T) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException("Deep copy failed", e);
    }
  }
}

abstract class Employee implements Serializable {
  // Recommended for Serializable classes
  private static final long serialVersionUID = 1L; 

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
}

class Address implements Serializable {
  // Recommended for Serializable classes
  private static final long serialVersionUID = 1L; 

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