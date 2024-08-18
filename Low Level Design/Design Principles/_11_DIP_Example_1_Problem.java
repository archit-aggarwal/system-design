import java.util.*;

public class _11_DIP_Example_1_Problem {
  public static void main(String[] args) {
    
  }
}

class SQLDatabase {
  public void save(User user) {}
  public void delete(String userId) {}
}

class UserRepository {
  SQLDatabase dbConnection;

  UserRepository() {
      this.dbConnection = new SQLDatabase();
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