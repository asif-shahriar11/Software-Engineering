public class SavingsAccount extends Account {

    SavingsAccount(String accountName, double initialDeposit, Bank bank) {
        super(accountName, initialDeposit, 0.0, 0.1);
        bank.setInternalFund(bank.getInternalFund() + initialDeposit);
    }

    @Override
    public void withdraw(double amount, Bank bank) {
        if(getDeposit()-amount < 1000) System.out.println("Withdrawing would result in insufficient deposit.");
        else if (amount > getDeposit()) System.out.println("Invalid transaction: Amount greater than current deposit.");
        else {
            setDeposit(getDeposit() - amount);
            bank.setInternalFund(bank.getInternalFund() - amount);
            System.out.println(amount + " withdrawn successfully. Current balance: "+getDeposit());
        }
    }

    @Override
    public void requestLoan(double amount) {
        if(amount < 10000)  {
            //setLoan(getLoan() + amount);
            //System.out.println("Loan of "+ amount + " granted.");
            setLoanRequested(true);
            setLoanRequestAmount(amount);
            System.out.println("Loan request waiting approval.");
        }
        else { System.out.println("Maximum allowable loan for Savings Account is 10000."); }
    }
}