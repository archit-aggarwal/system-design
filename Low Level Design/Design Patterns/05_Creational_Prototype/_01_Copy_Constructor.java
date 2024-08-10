class _01_Copy_Constructor {
  public static void main(String[] args) {
    Employee employee1 = new 
      Developer("Archit", 
      "Aggarwal", "SDE");
    System.out.println(employee1);

    // client needs to know about concrete 
    // classes if prototypes are not used
    if(employee1 instanceof Developer){
      Employee employee2 = 
        new Developer((Developer)employee1);
      System.out.println(employee2);
    }
  }
}

abstract class Employee {
  private String firstName;
  private String lastName;

  public Employee(String firstName, 
                  String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Employee(Employee other){
    this.firstName = other.firstName;
    this.lastName = other.lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}

class Developer extends Employee {
  private String role;

  public Developer(Developer other) {
    super(other);
    this.role = other.role;
  }

  public Developer(String firstName, 
        String lastName, String role) {
    super(firstName, lastName);
    this.role = role;
  }

  @Override
  public String toString() {
    return "Developer [role=" + role 
      + ", getFirstName()=" + getFirstName() 
      + ", getLastName()=" + getLastName();
  }
}










