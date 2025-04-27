package skillbuilder.indepth.sealed_classes.recordDemo;

public record EmployeeRecord(int eId, String eName, int eSalary) implements SealedInterf {
    @Override
    public void printSalary() {
        System.out.println(eSalary);
    }
}
