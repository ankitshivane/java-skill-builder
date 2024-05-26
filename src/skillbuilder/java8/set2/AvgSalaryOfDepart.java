package skillbuilder.java8.set2;

import java.util.Map;
import java.util.stream.Collectors;

public class AvgSalaryOfDepart {
	/**
	 * What is the average salary of each department?
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Map<String, Double> departWiseSalary = EmployeeDB.getAllEmployee().stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		departWiseSalary.entrySet().stream()
				.forEach(i -> System.out.println("Department:" + i.getKey() + ",avg salary:" + i.getValue()));
		/**
		 * OUTPUT:
		 * Department:Product Development,avg salary:31960.0
			Department:Security And Transport,avg salary:10750.25
			Department:Sales And Marketing,avg salary:11900.166666666666
			Department:Infrastructure,avg salary:15466.666666666666
			Department:HR,avg salary:23850.0
			Department:Account And Finance,avg salary:24150.0
		 * 
		 */
	}

}
