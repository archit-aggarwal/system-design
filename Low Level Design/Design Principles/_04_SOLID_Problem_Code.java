import java.time.LocalDate;
import java.util.HashMap;

public class _04_SOLID_Problem_Code {
  public static void main(String[] args) {
    
  }
}

interface IUserService {
  public abstract boolean authenticate(EmailAuthentication auth);
  public abstract boolean authenticate(MobileAuthentication auth);

  public abstract User getUserByEmailFromDB(String emailId);
  public abstract User getUserByPhoneFromDB(String phoneNo) ;
  public abstract User saveUserInDB(User user);
  
  public abstract void subscribe(User user, String subscriptionType);
  public abstract String getSubscriptionStatus(User user);
}

class UserService implements IUserService {
  HashMap<String, User> usersEmailMap = new HashMap<>();
  HashMap<String, User> usersPhoneMap = new HashMap<>();

  @Override
  public boolean authenticate(EmailAuthentication auth) {
    User user = getUserByEmailFromDB(auth.getEmailId());
    if(user == null) return false;
    return user.getPassword().equals(auth.getPassword());
  }

  @Override
  public boolean authenticate(MobileAuthentication auth) {
    User user = getUserByPhoneFromDB(auth.getPhoneNo());
    if(user == null) return false;
    return user.getPassword().equals(auth.getPassword());
  }

  @Override
  public User getUserByEmailFromDB(String emailId) {
    return usersEmailMap.get(emailId);
  }

  @Override
  public User getUserByPhoneFromDB(String phoneNo) {
    return usersPhoneMap.get(phoneNo);
  }

  @Override
  public User saveUserInDB(User user) {
    usersEmailMap.put(user.getEmailId(), user);
    usersPhoneMap.put(user.getPhoneNo(), user);

    if(user.getEmailId() != null) return usersEmailMap.get(user.getEmailId());
    else return usersPhoneMap.get(user.getPhoneNo());
  }

  @Override
  public String getSubscriptionStatus(User user) {
    Subscription subscription = user.getSubscription();
    if(subscription == null) return null;
    if(subscription instanceof UnlimitedSubscription) return "Unlimited";
    if(subscription.getSubscriptionEndDate().isBefore(LocalDate.now())) return "Expired";
    return subscription.getSubscriptionType();
  }

  @Override
  public void subscribe(User user, String subscriptionType) {
    Subscription subscription = null;
    if(subscriptionType.equals("Monthly")){
      subscription = new Subscription();
      subscription.setSubscriptionEndDate(LocalDate.now().plusDays(30));
    }
    else if(subscriptionType.equals("Yearly")){
      subscription = new Subscription();
      subscription.setSubscriptionEndDate(LocalDate.now().plusDays(365));
    }
    else if(subscriptionType.equals("Unlimited")){
      subscription = new UnlimitedSubscription();
    } 
    subscription.setSubscriptionType(subscriptionType);
  }
}

class Subscription {
  private String subscriptionType;
  private LocalDate subscriptionEndDate;

  public String getSubscriptionType() {
    return subscriptionType;
  }
  public void setSubscriptionType(String subscriptionType) {
    this.subscriptionType = subscriptionType;
  }
  public LocalDate getSubscriptionEndDate() {
    return subscriptionEndDate;
  }
  public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
    this.subscriptionEndDate = subscriptionEndDate;
  }
}

class UnlimitedSubscription extends Subscription {
  @Override
  public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
    throw new UnsupportedOperationException("No Subscription End Date");
  }

  @Override
  public LocalDate getSubscriptionEndDate() {
    throw new UnsupportedOperationException("No Subscription End Date");
  }
}

class User {
  private String name;
  private String emailId;
  private String phoneNo;
  private String password;
  private Subscription subscription;

  public Subscription getSubscription() {
    return subscription;
  }
  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }
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
}

class EmailAuthentication {
  private String emailId;
  private String password;

  public EmailAuthentication(String emailId, String password) {
    this.emailId = emailId;
    this.password = password;
  }
  public String getEmailId() {
    return emailId;
  }
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}

class MobileAuthentication {
  private String phoneNo;
  private String password;

  public MobileAuthentication(String phoneNo , String password) {
    this.phoneNo = phoneNo; 
    this.password = password;
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
}