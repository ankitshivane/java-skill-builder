package skillbuilder.java9.programs.privateMethods;

public class SavingAccount implements Bank {
    double balance = 1000;

    @Override
    public double withdraw(double amount) {
        this.balance -= amount;
        return this.balance;
    }

    @Override
    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    @Override
    public double printBalance() {
        return this.balance;
    }
}
