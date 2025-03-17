import java.util.Queue;
import java.util.LinkedList;

// Reusable Object (DatabaseConnection)
class DatabaseConnection {
    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
}

// Object Pool Manager
class DatabaseConnectionPool {
    private static final int POOL_SIZE = 3;
    private final Queue<DatabaseConnection> pool = new LinkedList<>();

    public DatabaseConnectionPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.add(new DatabaseConnection()); // Pre-create objects
        }
    }

    public DatabaseConnection getConnection() {
        if (pool.isEmpty()) {
            System.out.println("No available connections. Please wait...");
            return null;
        }
        return pool.poll();
    }

    public void releaseConnection(DatabaseConnection conn) {
        pool.add(conn);
    }
}

// Client Code
public class _02_Solution_ObjectPool {
  public static void main(String[] args) {
    DatabaseConnectionPool pool = new DatabaseConnectionPool();

    DatabaseConnection conn1 = pool.getConnection();
    conn1.executeQuery("SELECT * FROM users");

    DatabaseConnection conn2 = pool.getConnection();
    conn2.executeQuery("SELECT * FROM orders");

    pool.releaseConnection(conn1); 
    // Reuse connection instead of creating a new one

    DatabaseConnection conn3 = pool.getConnection();
    conn3.executeQuery("SELECT * FROM products");

    pool.releaseConnection(conn2);
    pool.releaseConnection(conn3);
  }
}
