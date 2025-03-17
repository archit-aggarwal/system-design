class DatabaseConnection {
  public DatabaseConnection() {
      System.out.println("New database connection created");
  }

  public void executeQuery(String query) {
      System.out.println("Executing: " + query);
  }
}

public class _01_Problem_ObjectPool {
  public static void main(String[] args) {
    DatabaseConnection conn1 = new DatabaseConnection();
    conn1.executeQuery("SELECT * FROM users");

    DatabaseConnection conn2 = new DatabaseConnection();
    conn2.executeQuery("SELECT * FROM orders");
    
    // Creates new connections every time :-
    // Expensive creation of new database connections.
    // No reuse, leading to resource wastage.
    // Scalability problems with a large number of requests.
  }
}
