public class LoanAccount extends Account {

    LoanAccount(String accountName, double initialLoan, Bank bank) {
        super(accountName, 0.0, initialLoan, 0.0);
        bank.setInternalFund(bank.getInternalFund() - initialLoan);
    }

    @Override
    public void depositMoney(double amount, Bank bank) {
        setLoan(getLoan() - amount);
        bank.setInternalFund(bank.getInternalFund() + amount);
        System.out.println(amount+" deposited successfully. Current loan: "+getLoan());
    }

    @Override
    public void withdraw(double amount, Bank bank) { System.out.println("Cannot withdraw from a Loan Account"); }

    @Override
    public void requestLoan(double amount) {
        if(amount < getLoan() * 0.05)  {
            //setLoan(getLoan() + amount);
            //System.out.println("Loan of "+ amount + " granted.");
            setLoanRequested(true);
            setLoanRequestAmount(amount);
            System.out.println("Loan request waiting approval.");
        }
        else { System.out.println("Maximum allowable loan is 5% of current loan."); }
    }
}
