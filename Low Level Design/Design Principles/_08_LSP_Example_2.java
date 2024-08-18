import java.util.*;

public class _08_LSP_Example_2 {
  public static void main(String[] args) {
    IUserService userService = new UserService_Good();
    System.err.println(userService.getAllUsersSortedByName());
  }
}


abstract class IUserService{
  public abstract SortedSet<User> getAllUsersSortedByName();
}

// Not Possible in Java
/* 
class UserService_Bad extends IUserService{
  @Override
  public Set<User> getAllUsersSortedByName(){
    Set<User> set = new TreeSet<>();
    return set;
  }
}
*/

class UserService_Good extends IUserService{
  @Override
  public TreeSet<User> getAllUsersSortedByName(){
    TreeSet<User> set = new TreeSet<>();
    set.add(new User("raman"));
    set.add(new User("pawan"));
    set.add(new User("chaman")); 
    return set;
  }
}

class User implements Comparable<User> {
  String userName;

  User(String userName){
    this.userName = userName;
  }

  @Override
  public int compareTo(User other) {
    return this.userName.compareTo(other.userName);
  }

  @Override
  public String toString(){
    return this.userName;
  }
}