import java.time.LocalDate;
import java.util.HashMap;

public class _04_SOLID_Solution_Code {
  public static void main(String[] args) {   
  }  
}

interface IUserAuthService {
  public abstract boolean authenticate(Authentication authentication);
}

interface IUserSubscriptionService {
  public abstract void subscribe(User user, Subscription subscription);
  public abstract String getSubscriptionStatus(User user);
}

class UserAuthService implements IUserAuthService {
  public boolean authenticate(Authentication authentication){
    return authentication.authenticate();
  } 
}

class UserSubscriptionService implements IUserSubscriptionService {
  @Override
  public String getSubscriptionStatus(User user) {
    Subscription subscription = user.getSubscription();
    if(subscription == null) return "No";
    else return subscription.getSubscriptionStatus();
  }

  @Override
  public void subscribe(User user, Subscription subscription) {
    if(user == null || subscription == null) return;
    subscription.subscribe(user);
  }
}

class UserController{
  HashMap<String, User> usersEmailMap, usersPhoneMap;

  static UserController singleton = new UserController();
  private UserController() {
    usersEmailMap = new HashMap<>();
    usersPhoneMap = new HashMap<>();
  }
  public static UserController getInstance(){
    return singleton;
  }

  public User getUserByEmailFromDB(String emailId) {
    return usersEmailMap.get(emailId);
  }

  public User getUserByPhoneFromDB(String phoneNo) {
    return usersPhoneMap.get(phoneNo);
  }

  public void saveUserInDB(User user) {
    usersEmailMap.put(user.getEmailId(), user);
    usersPhoneMap.put(user.getPhoneNo(), user);
  }
}

class User {
  private String name;
  private String emailId;
  private String phoneNo;
  private String password;
  private Subscription subscription;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmailId() {
    return emailId;
  }
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
  public String getPhoneNo() {
    return phoneNo;
  }
  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Subscription getSubscription() {
    return subscription;
  }
  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }
}

abstract class Authentication {
  String password;
  
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Authentication(String password){
    this.password = password;
  }

  public abstract boolean authenticate();
}

class EmailAuthentication extends Authentication {
  String emailId;

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public EmailAuthentication(String emailId, String password){
    super(password);
    this.emailId = emailId;
  }

  public boolean authenticate(){
    UserController controller = UserController.getInstance();
    User user = controller.getUserByEmailFromDB(this.getEmailId());
    if(user == null) return false;
    return user.getPassword().equals(this.getPassword());
  }
}

class PhoneAuthentication extends Authentication {
  String phoneNo;

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public PhoneAuthentication(String phoneNo, String password){
    super(password);
    this.phoneNo = phoneNo;
  }

  public boolean authenticate(){
    UserController controller = UserController.getInstance();
    User user = controller.getUserByPhoneFromDB(this.getPhoneNo());
    if(user == null) return false;
    return user.getPassword().equals(this.getPassword());
  }
}

interface Subscription {
  public abstract void subscribe(User user);
  public abstract String getSubscriptionStatus();
}

abstract class LimitedSubscription implements Subscription {
  private LocalDate subscriptionEndDate;

  public LocalDate getSubscriptionEndDate() {
    return subscriptionEndDate;
  }
  public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
    this.subscriptionEndDate = subscriptionEndDate;
  }

  public abstract void subscribe(User user);

  public abstract String getSubscriptionStatus();

  public boolean isActive(){
    return !(this.getSubscriptionEndDate().isBefore(LocalDate.now()));
  }
}

class MonthlySubscription extends LimitedSubscription {
  @Override
  public void subscribe(User user) {
    super.setSubscriptionEndDate(LocalDate.now().plusDays(30));
    user.setSubscription(this);
  }

  @Override
  public String getSubscriptionStatus() {
    if(super.isActive() == false) return "Expired";
    else return "Monthly";
  }
}

class YearlySubscription extends LimitedSubscription {
  @Override
  public void subscribe(User user) {
    super.setSubscriptionEndDate(LocalDate.now().plusDays(365));
    user.setSubscription(this);
  }

  @Override
  public String getSubscriptionStatus() {
    if(super.isActive() == false) return "Expired";
    else return "Yearly";
  }
}

class UnlimitedSubscription implements Subscription {
  public void subscribe(User user){
    System.out.println("Unlimited Subscription");
    user.setSubscription(this);
  }

  @Override
  public String getSubscriptionStatus() {
    return "Unlimited";
  }
}