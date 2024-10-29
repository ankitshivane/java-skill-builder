package skillbuilder.java9.programs.privateMethods;

public interface Bank {
    double withdraw(double amount); //abstract methods

    double deposit(double amount);

    double printBalance();

    default void executeTransactions(String transactionType, double amount) {
        if (transactionType.equalsIgnoreCase("Deposit")) {
            deposit(amount);
            logTransactions(transactionType, amount);
        } else if (transactionType.equalsIgnoreCase("Withdraw") && isSufficientBalance(amount)) {
            withdraw(amount);
            logTransactions(transactionType, amount);
        } else {
            System.out.println("Transaction can not be done...");
        }
    }

    private boolean isSufficientBalance(double amount) {
        System.out.println("checking balance is sufficient or not");
        return printBalance() >= amount;
    }

    private void logTransactions(String transactionType, double amount) {
        System.out.println("Performing " + transactionType + " for the amount of " + amount);
        System.out.println("Current Balance is:" + printBalance());
        System.out.println("************** Transaction Completed **************");
    }
}
