public class StudentAccount extends Account {

    StudentAccount(String accountName, double initialDeposit, Bank bank) {
        super(accountName, initialDeposit, 0.0, 0.05);
        bank.setInternalFund(bank.getInternalFund() + initialDeposit);
    }

    @Override
    public void withdraw(double amount, Bank bank) {
        if(amount > 10000) System.out.println("Student account cannot withdraw more than 10000.");
        else if (amount > getDeposit()) System.out.println("Invalid transaction: Amount greater than current deposit.");
        else {
            setDeposit(getDeposit() - amount);
            bank.setInternalFund(bank.getInternalFund() - amount);
            System.out.println(amount + " withdrawn successfully. Current balance: "+getDeposit());
        }
    }

    @Override
    public void requestLoan(double amount) {
        if(amount < 1000)  {
            //setLoan(getLoan() + amount);
            //System.out.println("Loan of "+ amount + " granted.");
            setLoanRequested(true);
            setLoanRequestAmount(amount);
            System.out.println("Loan request waiting approval.");
        }
        else { System.out.println("Maximum allowable loan for Student Account is 1000."); }
    }
}