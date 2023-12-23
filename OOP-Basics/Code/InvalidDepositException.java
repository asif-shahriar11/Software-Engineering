public class InvalidDepositException extends Exception {
    public String toString() { return "Initial Deposit for Fixed Deposit Account must be at least 100000"; }
}
