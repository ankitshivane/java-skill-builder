package skillbuilder.java8.set4;

import skillbuilder.java8.set2.Employee;
import skillbuilder.java8.set2.EmployeeDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationsonEmployee {
    public static void main(String[] args) {
        List<Employee> allEmployee = EmployeeDB.getAllEmployee();

//        grpEmpByAgeCoreJava(allEmployee);
        grpEmpByAgeByByjava8Approach1(allEmployee);
    }
    private static void grpEmpByAgeCoreJava(List<Employee> employees){
        Map<Integer,List<Employee>> groupByAge=new HashMap<>();
        for(Employee e:employees){
            if(!groupByAge.containsKey(e.getAge())){
                List<Employee> emp= new ArrayList<>();
                emp.add(e);
                groupByAge.put(e.getAge(),emp);
            } else{
              List<Employee> emps=groupByAge.get(e.getAge());
              emps.add(e);
              groupByAge.put(e.getAge(),emps);
            }
        }
        for (Integer age:groupByAge.keySet()){
            System.out.println("Key="+age+", Employees:"+groupByAge.get(age));
        }
    }

    private static void grpEmpByAgeByByjava8Approach1(List<Employee> employees){
        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));
        for (Integer age:collect.keySet()){
            System.out.println("Key="+age+", Employees:"+collect.get(age));
        }
    }
}
