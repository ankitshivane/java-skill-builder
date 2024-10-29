package skillbuilder.java9.programs.privateMethods;

public class DemoPrivateMethods {
    public static void main(String[] args) {
        Bank b = new SavingAccount();
        b.executeTransactions("deposit", 2000);
        b.executeTransactions("withdraw", 400);
        b.executeTransactions("withdraw", 6000);
//        b.logTransactions("withdraw", 6000); // If This line uncommented then we will get compile time error as this is a private method and can not be access from out of interface
    }

}
