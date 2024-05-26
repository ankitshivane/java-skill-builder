package skillbuilder.java8.set2;

import java.util.Comparator;
import java.util.Optional;

public class GetYoungestEmployee {

	/**
	 * Get the details of youngest male employee in the product development
	 * department?
	 */
	public static void main(String[] args) {
		Employee employee = EmployeeDB.getAllEmployee().stream()
				.filter(i -> i.getDepartment().equalsIgnoreCase("Product Development"))
				.sorted(Comparator.comparing(Employee::getAge)).findFirst().get();
		System.out.println(employee);
		/*
		 * output: Id : 222, Name : Nitin Joshi, age : 25, Gender : Male, Department :
		 * Product Development, Year Of Joining : 2016, Salary : 28200.0
		 * 
		 */
		// approach 2
		Optional<Employee> youngestEmployee = EmployeeDB.getAllEmployee().stream()
				.filter(i -> i.getDepartment().equalsIgnoreCase("Product Development"))
				.min(Comparator.comparingInt(Employee::getAge));
		youngestEmployee.ifPresent(i -> System.out.println(i));
		/**
		 * Id : 222, Name : Nitin Joshi, age : 25, Gender : Male, Department : Product
		 * Development, Year Of Joining : 2016, Salary : 28200.0
		 */
	}

}
