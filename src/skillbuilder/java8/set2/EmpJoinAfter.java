package skillbuilder.java8.set2;

import java.util.List;
import java.util.stream.Collectors;

public class EmpJoinAfter {

	/**
	 * Get the names of all employees who have joined after 2015?
	 * 
	 * 
	 */
	public static void main(String[] args) {

		List<String> namesOfEmployee = EmployeeDB.getAllEmployee().stream().filter(i -> i.getYearOfJoining() > 2015)
				.map(Employee::getName).collect(Collectors.toList());
		System.out.println(namesOfEmployee);
		/**
		 * output:[Iqbal Hussain, Amelia Zoe, Nitin Joshi, Nicolus Den, Ali Baig]
		 * 
		 */

	}

}
