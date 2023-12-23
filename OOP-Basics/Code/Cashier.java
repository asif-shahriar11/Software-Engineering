public class Cashier extends Employee {

    Cashier(String name) { super (name); }

    @Override
    public void approveLoan(Account account) {
        System.out.println("You do not have permission for this action.");
    }
}
