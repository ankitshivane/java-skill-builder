package skillbuilder.java8.set2;

import java.util.Map;
import java.util.stream.Collectors;

public class HowManyMaleAndFemale {
	/**
	 * How many male and female employees are there in the organization?
	 */
	public static void main(String[] args) {
		Map<String, Long> employeeStats = EmployeeDB.getAllEmployee().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(employeeStats);
	}

}
