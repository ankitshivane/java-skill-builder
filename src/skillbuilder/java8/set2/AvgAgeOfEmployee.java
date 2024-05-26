package skillbuilder.java8.set2;

import java.util.Map;
import java.util.stream.Collectors;

public class AvgAgeOfEmployee {

	/**
	 * What is the average age of male and female employees?
	 */
	public static void main(String[] args) {
		Map<String, Double> empAgeStat = EmployeeDB.getAllEmployee().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(empAgeStat);
	}

}
