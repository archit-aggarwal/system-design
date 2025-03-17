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

// Facade Class - Simplifies Loan Approval Process
class LoanApprovalFacade {
  private CreditCheckSystem creditCheck;
  private AccountVerificationSystem accountVerification;
  private LoanEligibilitySystem loanEligibility;

  public LoanApprovalFacade() {
      this.creditCheck = new CreditCheckSystem();
      this.accountVerification = new AccountVerificationSystem();
      this.loanEligibility = new LoanEligibilitySystem();
  }

  public String approveLoan(String customerId, double amount) {
      System.out.println("\nProcessing loan approval for " + customerId);
      boolean isApproved = creditCheck.hasGoodCredit(customerId) &&
             accountVerification.isAccountValid(customerId) &&
             loanEligibility.isEligible(customerId, amount);
      
      if(isApproved) return "Loan Approved!";
      else return "Loan Rejected.";
  }
}


public class _02_Solution_Facade {
  public static void main(String[] args) {
    LoanApprovalFacade loanApproval = new LoanApprovalFacade();
    System.out.println(loanApproval.approveLoan("12345", 50000));
  }  
}
