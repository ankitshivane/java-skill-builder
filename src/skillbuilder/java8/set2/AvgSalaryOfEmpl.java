package skillbuilder.java8.set2;

import java.util.Map;
import java.util.stream.Collectors;

public class AvgSalaryOfEmpl {

	/**
	 * What is the average salary of male and female employees?
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Map<String, Double> stat = EmployeeDB.getAllEmployee().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(stat);
		/**
		 * output:
		 * {Male=21300.090909090908, Female=20850.0}
		 */
	}

}
