import java.util.LinkedList;

public class ManagingDirector extends Employee {

    ManagingDirector(String name) { super(name);}

    @Override
    public void seeFund(Bank bank) {
        System.out.println("Internal Fund: "+bank.getInternalFund());
    }

    @Override
    public void changeSavingsInterestRate(double newRate, LinkedList<Account> accountsList) {
        for(Account account:accountsList) {
            if(account instanceof SavingsAccount)   account.setInterestRate(newRate);
        }
    }

    @Override
    public void changeStudentInterestRate(double newRate, LinkedList<Account> accountsList) {
        for(Account account:accountsList) {
            if(account instanceof StudentAccount)   account.setInterestRate(newRate);
        }
    }

    @Override
    public void changeFixedDepositInterestRate(double newRate, LinkedList<Account> accountsList) {
        for(Account account:accountsList) {
            if(account instanceof FixedDepositAccount)   account.setInterestRate(newRate);
        }
    }
}