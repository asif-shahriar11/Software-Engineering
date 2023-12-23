import java.util.LinkedList;

public class Bank {
    private LinkedList<Account> accounts;
    private LinkedList<Employee> employees;
    private double internalFund;
    private int yearCount;

    Bank() {
        accounts = new LinkedList<>();
        employees = new LinkedList<>();
        internalFund = 1000000;
        yearCount = 0;

        employees.add(new ManagingDirector("MD"));
        employees.add(new Officer("O1"));
        employees.add(new Officer("O2"));
        employees.add(new Cashier("C1"));
        employees.add(new Cashier("C2"));
        employees.add(new Cashier("C3"));
        employees.add(new Cashier("C4"));
        employees.add(new Cashier("C5"));
    }

    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    public LinkedList<Account> getAccounts() {
        return accounts;
    }

    public double getInternalFund() {
        return internalFund;
    }

    public void setInternalFund(double internalFund) {
        this.internalFund = internalFund;
    }

    public int getYearCount() {
        return yearCount;
    }

    public void setYearCount(int yearCount) {
        this.yearCount = yearCount;
    }
}
