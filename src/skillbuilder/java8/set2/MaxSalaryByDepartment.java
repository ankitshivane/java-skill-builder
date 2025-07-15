package skillbuilder.java8.set2;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxSalaryByDepartment {
    /**
     *  group the employees by their respective departments and identify the maximum salary within each department.
     */
    public static void main(String[] args) {
        Map<String, Optional<Employee>> maxSalaryByDepartment = EmployeeDB.getAllEmployee().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));
        for (String key:maxSalaryByDepartment.keySet()){
            System.out.println("Key:"+key+
                    ",Emp Id:"+maxSalaryByDepartment.get(key).get().getId()
            +",Emp Salary:"+maxSalaryByDepartment.get(key).get().getSalary());
        }

    }
}
