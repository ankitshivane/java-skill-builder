package skillbuilder.java9.programs.privateMethods;

public interface Bank {
    double withdraw(double amount); //abstract methods

    double deposit(double amount);

    double printBalance();

    default void executeTransactions(String transactionType, double amount) {
        if (transactionType.equals("Deposit")) {

        }
    }
}
