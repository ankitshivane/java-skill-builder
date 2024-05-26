package skillbuilder.java8.set2;

import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStatInSalesDepart {

	/**
	 * How many male and female employees are there in the sales and marketing team?
	 */
	public static void main(String[] args) {

		Map<String, Long> stat = EmployeeDB.getAllEmployee().stream()
				.filter(i -> i.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(stat);
		/**
		 * output:{Female=1, Male=2}
		 * 
		 */
	}

}
