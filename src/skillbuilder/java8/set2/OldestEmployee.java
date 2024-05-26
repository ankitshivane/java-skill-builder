package skillbuilder.java8.set2;

import java.util.Comparator;
import java.util.Optional;

public class OldestEmployee {

	/**
	 * Who is the oldest employee in the organization? What is his age and which
	 * department he belongs to?
	 */
	public static void main(String[] args) {
		Employee oldestEmployee = EmployeeDB.getAllEmployee().stream()
				.sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst().get();
		System.out.println("Age:" + oldestEmployee.getAge());
		System.out.println("Department:" + oldestEmployee.getDepartment());

		// approach 2
		Optional<Employee> max = EmployeeDB.getAllEmployee().stream().max(Comparator.comparingInt(Employee::getAge));
		max.ifPresent(i -> {
			System.out.println("approach 2 Age:" + oldestEmployee.getAge());
			System.out.println("approach 2 Department:" + oldestEmployee.getDepartment());
		});
		
		/**
		 * Age:43
			Department:Security And Transport
			approach 2 Age:43
			approach 2 Department:Security And Transport

		 */
	}

}
