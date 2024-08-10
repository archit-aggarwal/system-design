import java.util.HashMap;

class Problem {
  HashMap<String, String> userDB = new HashMap<>();

  public String login(String email, String password) {
    if (email.matches(".*@.+\\.com$") == false) 
      return "Please enter a valid email id";
    if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$") == false) 
      return "Please enter a valid password";
    if (userDB.containsKey(email) == false || userDB.get(email) != password) 
      return "Email and password not matched";
    userDB.put(email, password);
    return "Login Successful";
  }

  public String setPassword(String email, String oldPassword, String newPassword) {
    if (email.matches(".*@.+\\.com$") == false) 
      return "Please enter a valid email id";
    if (oldPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$") == false) 
      return "Please enter a valid password";
    if (userDB.containsKey(email) == false || userDB.get(email) != oldPassword) 
      return "Email and password not matched";
    if (newPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$") == false) 
      return "Please enter a valid password";
    userDB.put(email, newPassword);
    return "Password Updation Successful";
  }
}

class Solution {
  HashMap<String, String> userDB = new HashMap<>();

  private final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
  private final String EMAIL_REGEX = ".*@.+\\.com$";
  private final String INVALID_EMAIL_ERROR = "Please enter a valid email id";
  private final String INVALID_PASSWORD_ERROR = "Please enter a valid password";
  private final String PASSWORD_MISMATCH_ERROR = "Email and password not matched";

  public String login(String email, String password) {
      String validationError = validateCredentials(email, password);
      if (validationError != null) return validationError;
      return "Login Successful";
  }

  public String setPassword(String email, String oldPassword, String newPassword) {
      String validationError = validateCredentials(email, oldPassword);
      if (validationError != null) return validationError;
      if (!validatePassword(newPassword)) return INVALID_PASSWORD_ERROR;
      userDB.put(email, newPassword);
      return "Password Updation Successful";
  }

  private String validateCredentials(String email, String password) {
      if (!validateEmail(email)) return INVALID_EMAIL_ERROR;
      if (!validatePassword(password)) return INVALID_PASSWORD_ERROR;
      if (!validateUserDB(email, password)) return PASSWORD_MISMATCH_ERROR;
      return null;
  }

  private boolean validateEmail(String email) {
      return email.matches(EMAIL_REGEX);
  }

  private boolean validatePassword(String password) {
      return password.matches(PASSWORD_REGEX);
  }

  private boolean validateUserDB(String email, String password) {
      return userDB.containsKey(email) && userDB.get(email).equals(password);
  }
}