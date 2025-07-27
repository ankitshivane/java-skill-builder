package skillbuilder.java8.set4;

import skillbuilder.java8.set2.Employee;
import skillbuilder.java8.set2.EmployeeDB;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
    record Person(Integer pId,String pName){}

    public static void main(String[] args) {
        List<Person> allPerson = Arrays.asList(new Person(1, "ankit"),
                new Person(2, "Adwitya"),
                new Person(3, "Sameer"),
                new Person(4, "Vikrant"),
                new Person(4, "Vikrant"));

        Map<Integer,String> personMap=
        allPerson.stream().collect(Collectors.toMap(
                Person::pId,
                Person::pName,
                (first,second)->first
        ));
        System.out.println(personMap);
    }
}
