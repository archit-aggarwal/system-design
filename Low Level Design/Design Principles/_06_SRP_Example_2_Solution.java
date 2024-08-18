import java.util.HashMap;
import java.util.Map;

class UserProfile {
  private String userName;
  private String bio;
  private boolean blueTick = false;
  private String accountStatus = "ACTIVE";

  public String getBio() { return bio; }

  public void setBio(String bio) { this.bio = bio; }

  public String getUserName() { return userName; }

  public void setUserName(String userName) 
  { this.userName = userName; }

  public boolean isBlueTick() { return blueTick; }

  public void setBlueTick(boolean blueTick) 
  { this.blueTick = blueTick; }

  public String getAccountStatus() { return accountStatus; }

  public void setAccountStatus(String accountStatus) 
  { this.accountStatus = accountStatus; }
}

class UserService {
  private Map<String, UserProfile> userDB = new HashMap<>();

  public void updateUserName(String userName, String newUserName) {
      UserProfile user = userDB.get(userName);
      if (user == null || userDB.containsKey(newUserName)) return;

      userDB.remove(userName);
      user.setUserName(newUserName);
      userDB.put(newUserName, user);
  }

  public void updateBio(String userName, String bio) {
      UserProfile user = userDB.get(userName);
      if (user == null) return;

      user.setBio(bio);
  }

  public UserProfile getUserProfile(String userName) {
      return userDB.get(userName);
  }
}

class AdminService {
  private UserService userService;

  public AdminService(UserService userService) {
      this.userService = userService;
  }

  public void updateStatus(String userName, String status) {
      UserProfile user = userService.getUserProfile(userName);
      if (user == null) return;

      user.setAccountStatus(status);
  }

  public void updateBlueTick(String userName, boolean blueTick) {
      UserProfile user = userService.getUserProfile(userName);
      if (user == null) return;

      user.setBlueTick(blueTick);
  }
}


// Example usage
public class _06_SRP_Example_2_Solution {
  public static void main(String[] args) {
      
  }
}

