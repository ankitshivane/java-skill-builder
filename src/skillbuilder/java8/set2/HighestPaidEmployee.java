package skillbuilder.java8.set2;

import java.util.Comparator;
import java.util.Optional;

public class HighestPaidEmployee {

	/**
	 * Get the details of highest paid employee in the organization?
	 * 
	 */
	public static void main(String[] args) {
		Optional<Employee> max = EmployeeDB.getAllEmployee().stream()
				.max(Comparator.comparingDouble(Employee::getSalary));
		max.ifPresent(i -> System.out.println(i));
	}

}
