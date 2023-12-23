public abstract class Account {
    private final String accountName;
    private double deposit;
    private double loan;
    private double interestRate;

    private boolean loanRequested;
    private double loanRequestAmount;

    public Account(String accountName, double deposit, double loan, double interestRate) {
        this.accountName = accountName;
        this.deposit = deposit;
        this.loan = loan;
        this.interestRate = interestRate;

        loanRequested = false;
        loanRequestAmount = 0.0;

        System.out.println("Account successfully created with name : "+accountName);
    }

    // getter and setter


    public double getInterestRate() { return interestRate; }

    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public String getAccountName() { return accountName; }

    public double getDeposit() { return deposit; }

    public void setDeposit(double deposit) { this.deposit = deposit; }

    public double getLoan() { return loan; }

    public void setLoan(double loan) { this.loan = loan; }

    public boolean isLoanRequested() { return loanRequested; }

    public void setLoanRequested(boolean loanRequested) { this.loanRequested = loanRequested; }

    public double getLoanRequestAmount() {
        return loanRequestAmount;
    }

    public void setLoanRequestAmount(double loanRequestAmount) {
        this.loanRequestAmount = loanRequestAmount;
    }

    // methods

    public void depositMoney(double amount, Bank bank) {
        deposit += amount;
        bank.setInternalFund(bank.getInternalFund() + amount);
        System.out.println(amount + " deposited successfully. Current balance: "+getDeposit());
    }

    public void queryDeposit() {
        System.out.println("Account name: "+getAccountName()+" Current balance: "+getDeposit()+" Loan: "+getLoan());
    }

    abstract public void withdraw(double amount, Bank bank);

    abstract public void requestLoan(double amount);


}