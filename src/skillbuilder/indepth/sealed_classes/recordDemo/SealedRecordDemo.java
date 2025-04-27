package skillbuilder.indepth.sealed_classes.recordDemo;

public class SealedRecordDemo {
    public static void main(String[] args) {
        EmployeeRecord e = new EmployeeRecord(1, "Ankit", 50000);
        e.printSalary();
    }
}
