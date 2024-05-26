package skillbuilder.java8.set2;

import java.util.List;
import java.util.stream.Collectors;

public class PrintNameOfAllDept {

	/**
	 * Print the name of all departments in the organization?
	 */
	public static void main(String[] args) {
		List<String> listOfDepartments = EmployeeDB.getAllEmployee().stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println(listOfDepartments);
	}

}
