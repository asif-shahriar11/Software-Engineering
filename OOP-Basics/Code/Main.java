import java.util.Scanner;

public class Main {

    static void showHomePage() {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to The Bank.");
        System.out.println("To login/sign-up as user...press 1");
        System.out.println("To login as employee...press 2");
        System.out.println("To increase 1 year...press 3");
        System.out.println("To exit...press 4");
        System.out.println();
    }

    public static void main(String[] args) {
        Account currentAccount = null;
        Employee currentEmployee = null;

        Bank bank = new Bank();

        Scanner input = new Scanner(System.in);

        boolean isRunning = true;



        while (isRunning) {
            showHomePage();
            int option = input.nextInt();
            input.nextLine();
            if(option == 1) {
                System.out.println("To login...press 1");
                System.out.println("To sign-up...press 2");
                int option2 = input.nextInt();
                input.nextLine();
                String accName;
                if(option2 == 1) {
                    // login
                    System.out.println("Enter Account name: ");
                    accName = input.nextLine();
                    boolean isFound = false;
                    for(Account account:bank.getAccounts()) {
                        if(account.getAccountName().equals(accName)) {
                            currentAccount = account;
                            isFound = true;
                            break;
                        }
                    }
                    if(isFound) {
                        while (true) {
                            System.out.println();
                            System.out.println();

                            System.out.println("Welcome, "+accName+".");
                            System.out.println();
                            System.out.println("To deposit money...press 1");
                            System.out.println("To withdraw money...press 2");
                            System.out.println("To request loan...press 3");
                            System.out.println("To view deposit...press 4");
                            System.out.println("To log out...press 5");
                            int option3 = input.nextInt();
                            input.nextLine();
                            if(option3 == 1) {
                                // deposit
                                System.out.print("Enter deposit amount: ");
                                double depositAmount = input.nextDouble();
                                input.nextLine();
                                currentAccount.depositMoney(depositAmount, bank);
                            }
                            else if(option3 == 2) {
                                // withdraw
                                System.out.print("Enter amount to withdraw: ");
                                double withdrawAmount = input.nextDouble();
                                input.nextLine();
                                currentAccount.withdraw(withdrawAmount, bank);
                            }
                            else if(option3 == 3) {
                                //request loan
                                System.out.print("Enter loan amount: ");
                                double loanAmount = input.nextDouble();
                                input.nextLine();
                                currentAccount.requestLoan(loanAmount);
                            }
                            else if(option3 == 4) {
                                // view deposit
                                currentAccount.queryDeposit();
                            }
                            else if(option3 == 5) {
                                currentAccount = null;
                                break;
                            }
                            else System.out.println("Invalid choice");
                        }
                    }
                    else System.out.println("No account in this name.");
                }

                else if(option2 == 2) {
                    // sign-up
                    System.out.print("Enter account name: ");
                    accName = input.nextLine();
                    boolean isFound = false;
                    for(Account account:bank.getAccounts()) {
                        if(account.getAccountName().equals(accName)) {
                            currentAccount = account;
                            isFound = true;
                            break;
                        }
                    }
                    if(isFound) {
                        System.out.println("Account already exists in this name.");
                    }
                    else {
                        System.out.println("Enter account type.");
                        System.out.println("Savings...press 1");
                        System.out.println("Student...press 2");
                        System.out.println("Loan...press 3");
                        System.out.println("Fixed Deposit...press 4");
                        int accChoice = input.nextInt();
                        input.nextLine();
                        System.out.println();
                        if(accChoice == 3) System.out.print("Loan amount: ");
                        else System.out.println("Deposit amount: ");
                        double initialDepositAmount = input.nextDouble();
                        input.nextLine();

                        if(accChoice == 1) bank.getAccounts().add(new SavingsAccount(accName, initialDepositAmount, bank));
                        else if(accChoice == 2) bank.getAccounts().add(new StudentAccount(accName, initialDepositAmount, bank));
                        else if(accChoice == 3) bank.getAccounts().add(new LoanAccount(accName, initialDepositAmount, bank));
                        else if(accChoice == 4) {
                            try {
                                bank.getAccounts().add(new FixedDepositAccount(accName, initialDepositAmount, bank));
                            } catch (InvalidDepositException e) {
                                //e.printStackTrace();
                                System.out.println(e);
                            }
                        }
                        else System.out.println("Invalid choice");
                    }
                }
                else System.out.println("Invalid choice");

            }

            else if (option == 2) {
                // employee
                System.out.println();
                System.out.print("Enter name: ");
                String empName = input.nextLine();
                boolean isFound = false;
                for(Employee employee: bank.getEmployees()) {
                    if(employee.getEmployeeName().equals(empName)) {
                        currentEmployee = employee;
                        isFound = true;
                        break;
                    }
                }
                if(isFound) {

                    while (true) {
                        System.out.println();
                        System.out.println();
                        System.out.println("Welcome, " + currentEmployee.getEmployeeName());
                        boolean isLoanPending = false;
                        for(Account account: bank.getAccounts()) {
                            if(account.isLoanRequested())   isLoanPending = true;
                            break;
                        }
                        if(isLoanPending) System.out.println("You have loan request pending.");
                        System.out.println();
                        System.out.println("To look up...press 1");
                        System.out.println("To approve loan...press 2");
                        System.out.println("To change interest...press 3");
                        System.out.println("To see internal fund...press 4");
                        System.out.println("To exit...press 5");
                        System.out.println();

                        int empOption = input.nextInt();
                        input.nextLine();

                        if(empOption == 1) {
                            // look up
                            System.out.print("Enter account name to look up: ");
                            String lookUpAccountName = input.nextLine();
                            int idx = -1;
                            for (Account account: bank.getAccounts()) {
                                if(account.getAccountName().equals(lookUpAccountName))  idx = bank.getAccounts().indexOf(account);
                            }
                            if(idx == -1) System.out.println("No account in this name.");
                            else currentEmployee.lookUp(bank.getAccounts().get(idx));
                        }
                        else if(empOption == 2) {
                            // approve loan
                            if(isLoanPending) {
                                for(Account account: bank.getAccounts()) {
                                    if(account.isLoanRequested()) {
                                        if(account.getLoanRequestAmount() < bank.getInternalFund()) {
                                            currentEmployee.approveLoan(account);
                                        }
                                    }
                                }
                            }
                            else System.out.println("No loan pending.");
                        }
                        else if (empOption == 3) {
                            // change interest
                            System.out.println("To change Savings interest...press 1");
                            System.out.println("To change Student interest...press 2");
                            System.out.println("To change Fixed Deposit interest...press 3");
                            int interestChoice = input.nextInt();
                            input.nextLine();
                            System.out.println();
                            System.out.print("Enter new rate: ");
                            double newRate = input.nextDouble();
                            input.nextLine();
                            if(interestChoice == 1) currentEmployee.changeSavingsInterestRate(newRate, bank.getAccounts());
                            else if(interestChoice == 2) currentEmployee.changeStudentInterestRate(newRate, bank.getAccounts());
                            else if(interestChoice == 3) currentEmployee.changeFixedDepositInterestRate(newRate, bank.getAccounts());
                        }
                        else if(empOption == 4) {
                            // see internal fund
                            currentEmployee.seeFund(bank);
                        }
                        else if(empOption == 5) {
                            currentEmployee = null;
                            break;
                        }
                        else System.out.println("Invalid choice");
                    }

                }
                else System.out.println("No employee in this name.");
            }

            else if(option == 3) {
                // 1 year passed
                bank.setYearCount(bank.getYearCount()+1);
                for(Account account: bank.getAccounts()) {
                    if(account instanceof LoanAccount) {
                        account.setLoan(account.getLoan() + account.getLoan() * 0.1);
                    }
                    else {
                        // interest, 10% loan + service fee deduction
                        account.setDeposit(account.getDeposit() + account.getDeposit() * account.getInterestRate() - account.getLoan() * 0.1 - 500.0);
                        if(account instanceof FixedDepositAccount) ((FixedDepositAccount) account).setFixedDepositYear(((FixedDepositAccount) account).getFixedDepositYear()+1);
                    }
                }
            }

            else if(option == 4) {
                isRunning = false;
            }
            else System.out.println("Invalid choice.");
        }

        input.close();


    }
}
