public class FixedDepositAccount extends Account {

    private int fixedDepositYear;

    FixedDepositAccount(String accountName, double initialDeposit, Bank bank) throws InvalidDepositException {
        super(accountName, checkAmount(initialDeposit), 0.0, 0.15);
        fixedDepositYear = 0;
        bank.setInternalFund(bank.getInternalFund() + initialDeposit);
    }

    public int getFixedDepositYear() {
        return fixedDepositYear;
    }

    public void setFixedDepositYear(int fixedDepositYear) {
        this.fixedDepositYear = fixedDepositYear;
    }

    private static double checkAmount(double amount) throws InvalidDepositException {
        if(amount < (double) 100000) throw new InvalidDepositException();
        else return amount;
    }

    @Override
    public void depositMoney(double amount, Bank bank) {
        if(amount < 50000) System.out.println("Deposit amount for Fixed Deposit must be at least 50000");
        else {
            setDeposit(getDeposit() + amount);
            bank.setInternalFund(bank.getInternalFund() + amount);
            System.out.println(amount+" deposited successfully. Current balance: "+getDeposit());
        }
    }

    @Override
    public void withdraw(double amount, Bank bank) {
        if (amount > getDeposit()) System.out.println("Invalid transaction: Amount greater than current deposit.");
        else if (fixedDepositYear < 1) System.out.println("Cannot withdraw before maturity period of 1 year.");
        else {
            setDeposit(getDeposit() - amount);
            bank.setInternalFund(bank.getInternalFund() - amount);
            System.out.println(amount + " withdrawn successfully. Current balance: "+getDeposit());
        }
    }

    @Override
    public void requestLoan(double amount) {
        if(amount < 100000)  {
            //setLoan(getLoan() + amount);
            //System.out.println("Loan of "+ amount + " granted.");
            setLoanRequested(true);
            setLoanRequestAmount(amount);
            System.out.println("Loan request waiting approval.");
        }
        else { System.out.println("Maximum allowable loan for Fixed Deposit Account is 100000."); }
    }
}
