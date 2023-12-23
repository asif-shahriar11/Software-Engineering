import java.util.LinkedList;

public class Employee {

    private String employeeName;
    Employee(String employeeName) {
        this.employeeName = employeeName;
        //System.out.println("Employee created.");
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // default methods
    public void lookUp(Account account) { account.queryDeposit(); }

    public void approveLoan(Account account) {
        if(account.isLoanRequested()) {
            account.setLoan(account.getLoan() + account.getLoanRequestAmount());
            if (!(account instanceof LoanAccount))  account.setDeposit(account.getDeposit() + account.getLoanRequestAmount());
            account.setLoanRequestAmount(0.0);
            account.setLoanRequested(false);
        }
    }

    public void seeFund(Bank bank) {
        System.out.println("You do not have permission for this operation.");
    }


    public void changeSavingsInterestRate(double newRate, LinkedList<Account> accountsList) {
        System.out.println("You do not have permission for this operation.");
    }

    public void changeStudentInterestRate(double newRate, LinkedList<Account> accountsList) {
        System.out.println("You do not have permission for this operation.");
    }

    public void changeFixedDepositInterestRate(double newRate, LinkedList<Account> accountsList) {
        System.out.println("You do not have permission for this operation.");
    }
}
