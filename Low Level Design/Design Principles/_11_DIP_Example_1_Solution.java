import java.util.*;

public class _11_DIP_Example_1_Solution {
  public static void main(String[] args) {
    
  }
}

interface Database {
  void save(User user);
  void delete(String userId);
}

class SQLDatabase implements Database {
  public void save(User user) {}
  public void delete(String userId) {}
}

class RedisDatabase implements Database {
  public void save(User user) {}
  public void delete(String userId) {}
}

class UserRepository {
  Database dbConnection;

  UserRepository(Database dbConnection) {
      this.dbConnection = dbConnection;
  }

  public void saveUsers(List<User> users){
    for(User user : users){
      this.saveUser(user);
    }
  }

  public void saveUser(User user){
    dbConnection.save(user);
  }

  public void deleteUser(String userId){
    dbConnection.delete(userId);
  }
}

class User {
  String userId;
  String userName;
}