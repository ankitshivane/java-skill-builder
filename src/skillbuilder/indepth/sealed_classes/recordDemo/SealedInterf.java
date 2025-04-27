package skillbuilder.indepth.sealed_classes.recordDemo;

public sealed interface SealedInterf permits EmployeeRecord {
    void printSalary();
}
