class CreditCheckSystem {
  public boolean hasGoodCredit(String customerId) {
      System.out.println("Checking credit score for " + customerId);
      return true;  // Assume good credit
  }
}

class AccountVerificationSystem {
  public boolean isAccountValid(String customerId) {
      System.out.println("Verifying account for " + customerId);
      return true;  // Assume valid account
  }
}

class LoanEligibilitySystem {
  public boolean isEligible(String customerId, double amount) {
      System.out.println("Checking loan eligibility for " 
                    + customerId + " for amount: " + amount);
      return true;  // Assume eligible
  }
}

// ❌ PROBLEM: Client Code directly interacting with multiple subsystems
public class _01_Problem_Facade {
  public static void main(String[] args) {
    String customerId = "12345";
    double amount = 50000;

    CreditCheckSystem creditCheck = new CreditCheckSystem();
    AccountVerificationSystem accountVerification = new AccountVerificationSystem();
    LoanEligibilitySystem loanEligibility = new LoanEligibilitySystem();

    if (creditCheck.hasGoodCredit(customerId) && 
        accountVerification.isAccountValid(customerId) &&
        loanEligibility.isEligible(customerId, amount)) {
        System.out.println("Loan Approved for " + customerId);
    } else {
        System.out.println("Loan Rejected for " + customerId);
    }
  } 
}
