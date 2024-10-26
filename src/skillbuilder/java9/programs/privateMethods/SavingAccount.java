package skillbuilder.java9.programs.privateMethods;

public class SavingAccount implements Bank {
    double amount = 1000;

    @Override
    public double withdraw(double amount) {
        this.amount -= amount;
        return this.amount;
    }

    @Override
    public double deposit(double amount) {
        this.amount += amount;
        return this.amount;
    }

    @Override
    public double printBalance() {
        return this.amount;
    }
}
